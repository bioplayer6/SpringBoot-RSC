package project.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.pojo.Area;
import project.pojo.Jia;
import project.pojo.Note;
import project.pojo.Paijian;
import project.pojo.Post;
import project.pojo.Post_workload;
import project.pojo.Shoujian;
import project.pojo.Status;
import project.pojo.Zai;
import project.service.AreaService;
import project.service.JiaService;
import project.service.NoteService;
import project.service.PaijianService;
import project.service.PostService;
import project.service.Post_workloadService;
import project.service.QingService;
import project.service.ShoujianService;
import project.service.StatusService;
import project.service.XiuService;
import project.service.ZaiService;
import project.util.Util;

@Controller
@RequestMapping("/post")
public class PostController {

	@Resource
	private PostService postService;
	
	@Resource
	private AreaService areaService;
	
	@Resource
	private StatusService statusService;
	
	@Resource
	private PaijianService paijianService;
	
	@Resource
	private ShoujianService shoujianService;
	
	@Resource
	private Post_workloadService workloadService;
	
	@Resource
	private QingService qingService;
	
	@Resource
	private XiuService xiuService;
	
	@Resource
	private ZaiService zaiService;
	
	@Resource
	private NoteService noteService;
	
	@Resource
	private JiaService jiaService;
	
	//跳转home页面
			@RequestMapping("/home")
			public String home() {
				return "post/home";
			}
	
	//跳转info页面
	@RequestMapping("/info")
	public String info() {
		return "post/info";
	}
			
	//跳转登录页面
		@RequestMapping("/index")
		public String index() {
			return "post/login";
		}
	
	//退出系统
		@RequestMapping("/fanhui")
		public String fanhui(HttpServletRequest request) {
			Post post=(Post)request.getSession().getAttribute("post");
			Integer max=jiaService.findMaxnumByPost(post.getPost_id());
			Integer max1=zaiService.findMaxnumByPost(post.getPost_id());
			if(post.getPost_work()==3) {
					Jia jia=jiaService.findRecentzai(max);
					Date current=Util.date(jia.getJia_start(), 1);
					jia.setJia_end(current);
					jiaService.saveJia(jia);		
			}
			Zai zai=zaiService.findRecentzai(max1);
			Date current1=Util.date(zai.getZai_start(), 1);
			zai.setZai_end(current1);
			zaiService.saveZai(zai);
			return "post/login";
		}
		
	//登录
		@RequestMapping("/login")
		public String login(String loginName, String password, HttpServletRequest request) {
			int result=postService.getPost(loginName, password, request);
			Post post=(Post)request.getSession().getAttribute("post");
			if(result==0)
				return "post/errorlogin";
			else {
				Integer zuida=workloadService.findRecentWorkloadMaxnumByPostId(post.getPost_id());
				Post_workload workload=workloadService.findRecentWorkloadById(zuida);
				if(post.getPost_work()==1) {
					Integer max=zaiService.findMaxnumByPost(post.getPost_id());
					Zai recent=zaiService.findRecentzai(max);
					Zai zai=new Zai();
					if(recent==null) {
					zai.setZai_start(new Date());
					zai.setZai_post(post);
					}else {
						if(recent.getZai_end()==null)
							return "post/index";
						Date current=Util.date(recent.getZai_end(), 1);
						zai.setZai_start(current);
						zai.setZai_post(post);
					}
					zaiService.saveZai(zai);
					if(workload==null) {
						Post_workload gongzuoliang=new Post_workload();
						Date current=new Date();
						Date weilai=Util.date(current, 30);
						gongzuoliang.setGongzi_start(current);
						gongzuoliang.setGongzi_end(weilai);
						gongzuoliang.setPost_re_broke(0);
						gongzuoliang.setPost_re_num(0);
						gongzuoliang.setPost_se_num(0);
						gongzuoliang.setPost_se_broke(0);
						gongzuoliang.setPost(post);
						workloadService.saveWorkload(gongzuoliang);
					}else {			
						Date bijiao=zai.getZai_start();
						if((bijiao.compareTo(workload.getGongzi_end())==-1))
						{}
						else {
							Post_workload gongzuoliang=new Post_workload();
							Date current=new Date();
							Date weilai=Util.date(current, 30);
							post.setWorkload(0);
							postService.savePost(post);
							gongzuoliang.setGongzi_start(current);
							gongzuoliang.setGongzi_end(weilai);
							gongzuoliang.setPost_re_broke(0);
							gongzuoliang.setPost_re_num(0);
							gongzuoliang.setPost_se_num(0);
							gongzuoliang.setPost_se_broke(0);
							gongzuoliang.setPost(post);
							workloadService.saveWorkload(gongzuoliang);
						}
					}
				}
				return "post/index";
			}
		}
		
	//收件
		@RequestMapping("/shoujian")
		public String shoujian(HttpServletRequest request) {
			Post post=(Post)request.getSession().getAttribute("post");
			List<Shoujian> shoujians=shoujianService.findShoujiansByPostId(post.getPost_id());
			request.getSession().setAttribute("shoujians", shoujians);
			return "post/shoujian";
		}
		
	//派件
		@RequestMapping("/paijian")
		public String paijian(HttpServletRequest request) {
			Post post=(Post)request.getSession().getAttribute("post");
			List<Paijian> paijians=paijianService.findPaijiansByPostId(post.getPost_id());
			request.getSession().setAttribute("paijians", paijians);
			return "post/paijian";
		}
		
		
	//计件
		@RequestMapping("/suanjian")
		public String suanjian(HttpServletRequest request) {
			Post post=(Post)request.getSession().getAttribute("post");
			Integer zuida=workloadService.findRecentWorkloadMaxnumByPostId(post.getPost_id());
			Post_workload workload=workloadService.findRecentWorkloadById(zuida);
			request.getSession().setAttribute("workload", workload);
			Integer max=zaiService.findDaysByPostId(post.getPost_id());
			Zai zai=zaiService.findRecentzai(max);
			Date milai=Util.date(zai.getZai_start(), 1);
			Date pass=Util.date(zai.getZai_start(), -30);
			Integer re_num=shoujianService.findShoujianNumsByDateById(zai.getZai_start(), milai, post.getPost_id());
			Integer se_num=paijianService.findPaijianNumsByDateById(zai.getZai_start(), milai, post.getPost_id());
			Integer re_broke=shoujianService.findShoujianBrokeNumsByDateById(zai.getZai_start(), milai, post.getPost_id());
			Integer se_broke=paijianService.findPaijianBrokeNumsByDateById(zai.getZai_start(), milai, post.getPost_id());
		    Post_workload workloadT=new Post_workload();
		    workloadT.setPost_re_num(re_num);
		    workloadT.setPost_re_broke(re_broke);
		    workloadT.setPost_se_num(se_num);
		    workloadT.setPost_se_broke(se_broke);
//分割	    
		    Integer re_num1=shoujianService.findShoujianNumsByDateById(pass, zai.getZai_start(), post.getPost_id());
			Integer se_num1=paijianService.findPaijianNumsByDateById(pass, zai.getZai_start(), post.getPost_id());
			Integer re_broke1=shoujianService.findShoujianBrokeNumsByDateById(pass, zai.getZai_start(), post.getPost_id());
			Integer se_broke1=paijianService.findPaijianBrokeNumsByDateById(pass, zai.getZai_start(), post.getPost_id());
			
			Post_workload workloadM=new Post_workload();
		    workloadM.setPost_re_num(re_num1);
		    workloadM.setPost_re_broke(re_broke1);
		    workloadM.setPost_se_num(se_num1);
		    workloadM.setPost_se_broke(se_broke1);
		    
		    request.getSession().setAttribute("workloadM", workloadM);
		    request.getSession().setAttribute("workloadT", workloadT);
			return "post/suanjian";
		}
		
	//改变收件状态
		@RequestMapping("/status")
		public String status(int st_id,Integer re_id,HttpServletRequest request) {
			Post post=(Post)request.getSession().getAttribute("post");
			Integer gongzi=post.getWorkload();
			Shoujian shoujian=shoujianService.findShoujianById(re_id);
			Paijian paijian=new Paijian();
			Integer max=workloadService.findRecentWorkloadMaxnumByPostId(post.getPost_id());
			Post_workload workload=workloadService.findRecentWorkloadById(max);
			Status status=statusService.findStateById(st_id);
			int re_num=workload.getPost_re_num();
			int re_broke=workload.getPost_re_broke();
            shoujian.setRe_status(status);
            Date end=Util.date(shoujian.getRe_startdate(), 1);
			if(st_id==3) {
				post.setWorkload(gongzi+1);
				postService.savePost(post);
				workload.setPost_re_num(re_num+1);
				workloadService.saveWorkload(workload);
				shoujian.setRe_enddate(end);
				shoujianService.saveShoujian(shoujian);
				paijian.setSe_customer_id(shoujian.getRe_customer_id());
				paijian.setSe_endaddress(shoujian.getRe_endaddress());
				paijian.setSe_name(shoujian.getRe_name());
				paijian.setSe_phone(shoujian.getRe_phone());
				paijian.setSe_startdate(new Date());
				paijian.setSe_stateaddress(shoujian.getRe_stateaddress());
				paijian.setSe_status(statusService.findStateById(1));
				List<Post> posts=postService.findAppropriatePost(shoujian.getRe_stateaddress());
				if(posts.isEmpty()) {
					return "post/home";
				}
				Post youchai=posts.get(posts.size()-1);
				paijian.setSe_post_id(youchai);
				paijianService.savePaijian(paijian);
			}
			else if(st_id>3) {
				workload.setPost_re_broke(re_broke+1);
				workloadService.saveWorkload(workload);
				shoujian.setRe_enddate(end);
				shoujianService.saveShoujian(shoujian);
			}
			else {
				shoujianService.saveShoujian(shoujian);
			}
			return "post/home";
		}
		
		//改变派件状态
				@RequestMapping("/Status")
				public String Status(int st_id,Integer se_id,HttpServletRequest request) {
					Post post=(Post)request.getSession().getAttribute("post");
					Integer gongzi=post.getWorkload();
					Paijian paijian=paijianService.findPaijianById(se_id);
					Integer max=workloadService.findRecentWorkloadMaxnumByPostId(post.getPost_id());
					Post_workload workload=workloadService.findRecentWorkloadById(max);
					Status status=statusService.findStateById(st_id);
					int se_num=workload.getPost_se_num();
					int se_broke=workload.getPost_se_broke();
		            paijian.setSe_status(status);
		            Date end=Util.date(paijian.getSe_startdate(), 1);
		            int num=paijian.getSe_num();
					if(st_id==3) {
						post.setWorkload(gongzi+1);
						postService.savePost(post);
						workload.setPost_se_num(se_num+1);
						workloadService.saveWorkload(workload);
						paijian.setSe_enddate(end);
						paijianService.savePaijian(paijian);
					}
					else if(st_id>3) {
						
						if(num<3) {
							paijianService.savePaijian(paijian);
						}else {
							workload.setPost_se_broke(se_broke+1);
							 workloadService.saveWorkload(workload);
							 paijian.setSe_enddate(end);
							 paijianService.savePaijian(paijian);
						}
					}
					else {
						paijianService.savePaijian(paijian);
					}
					return "post/home";
				}
			
		//修改加班状态
				@RequestMapping("/jia")
				public String jia(int id,HttpServletRequest request) {
					Post post=(Post)request.getSession().getAttribute("post");
					post.setPost_work(id);
					postService.savePost(post);
					Integer max=zaiService.findMaxnumByPost(post.getPost_id());
					Zai zai=zaiService.findRecentzai(max);
					Jia jia=new Jia();
					jia.setJia_post(post);
					jia.setJia_start(zai.getZai_start());
					jiaService.saveJia(jia);
					return "post/info";
				}
		//请求请假(休假)
				@RequestMapping("/xiu")
				public String xiu(int id,int day,HttpServletRequest request) {
					Post post=(Post)request.getSession().getAttribute("post");
					Note note=new Note();
					note.setNote_days(day);
					note.setNote_status(id);
					note.setNote_post(post);
					note.setNote_state(0);
					noteService.saveNote(note);
					return "post/info";
				}
		//择日派送
				@RequestMapping("/zeri")
				public String zeri(int se_id,int area_id) {
					Paijian paijian=paijianService.findPaijianById(se_id);
					Area area=areaService.findAreaById(area_id);
					List<Post> posts=postService.findAppropriatePost(area);
					if(posts.isEmpty()) {
						return "post/home";
					}
					Post post=posts.get(posts.size()-1);
					int num=paijian.getSe_num();
					paijian.setSe_num(num+1);
					paijian.setSe_post_id(post);
					paijian.setSe_status(statusService.findStateById(1));
					paijianService.savePaijian(paijian);
					return "post/home";
				}
}
