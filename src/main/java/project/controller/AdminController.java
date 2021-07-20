package project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.pojo.Area;
import project.pojo.Customer;
import project.pojo.Note;
import project.pojo.Paijian;
import project.pojo.Post;
import project.pojo.Post_situation;
import project.pojo.Post_workload;
import project.pojo.Qing;
import project.pojo.Shoujian;
import project.pojo.Xiu;
import project.pojo.Zai;
import project.service.AdminService;
import project.service.AreaService;
import project.service.CustomerService;
import project.service.JiaService;
import project.service.NoteService;
import project.service.PaijianService;
import project.service.PostService;
import project.service.Post_situationService;
import project.service.Post_workloadService;
import project.service.QingService;
import project.service.ShoujianService;
import project.service.StatusService;
import project.service.XiuService;
import project.service.ZaiService;
import project.util.Util;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private CustomerService custService;
	
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
	private AdminService adminService;
	
	@Resource
	private Post_workloadService workloadService;
	
	@Resource
	private Post_situationService situationService;
	
	@Resource
	private NoteService noteService;
	
	@Resource
	private ZaiService zaiService;
	
	@Resource
	private XiuService xiuService;
	
	@Resource
	private QingService qingService;
	
	@Resource
	private JiaService jiaService;
	
	@RequestMapping("/hand")
	public String hand(HttpServletRequest request) {
		List<Post> posts=postService.findAllPost();
		List<Customer> customers=custService.findAllCustomers();
		request.getSession().setAttribute("custs", customers);
		request.getSession().setAttribute("chais", posts);
		return "admin/hand";
	}
	//跳转登录页面
		@RequestMapping("/index")
		public String index() {
			return "admin/login";
		}
	//跳转添加邮差页面
		@RequestMapping("/post")
		public String post() {
			return "admin/addpost";
		}
	//跳转系统计件页面
		@RequestMapping("/suanjian")
		public String suanjian() {
			return "admin/suanjian";
		}
		
	//跳转首页
		@RequestMapping("/home")
		public String home() {
			return "admin/home";
		}
	
	//添加邮差
		@RequestMapping("/addpost")
		public String addpost(String post_name,String post_password,String post_phone,Integer area_id) {
			Post post=new Post();
			Area area=areaService.findAreaById(area_id);
			post.setPost_area(area);
			post.setPost_name(post_name);
			post.setPost_password(post_password);
			post.setPost_phone(post_phone);
			post.setPost_work(1);
			postService.savePost(post);
			return "admin/home";
		}
	//登录
		@RequestMapping("/login")
		public String login(String loginName, String password, HttpServletRequest request) {
			int result=adminService.findAdmin(loginName, password, request);
			if(result==0)
				return "admin/errorlogin";
			else {
				return "admin/index";
			}
		}
		
	//邮差
		@RequestMapping("/youchai")
		public String youchai(HttpServletRequest request) {
			List<Post> posts=postService.findAllPost();
			request.getSession().setAttribute("posts", posts);
			return "admin/youchai";
		}
		
	//用户
		@RequestMapping("/yonghu")
		public String yonghu(HttpServletRequest request) {
			List<Customer> customers=custService.findAllCustomers();
            request.getSession().setAttribute("customers", customers);
            return "admin/yonghu";
		}
		
	//派件
		@RequestMapping("/paijian")
		public String paijian(HttpServletRequest request) {
			List<Paijian> paijians=paijianService.getPaijians();
			request.getSession().setAttribute("paijians", paijians);
			return "admin/paijian";
		}
		
	//收件
		@RequestMapping("/shoujian")
		public String shoujian(HttpServletRequest request) {
			List<Shoujian> shoujians=shoujianService.getShoujians();
			request.getSession().setAttribute("shoujians", shoujians);
			return "admin/shoujian";
		}
		
	//按条件查询计件
		@RequestMapping("/suanjianF")
		public String suanjianF(String kaishi,String jiesu,HttpServletRequest request) throws ParseException {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
			kaishi+=" 00:00:00";
			jiesu+=" 00:00:00";
			Date start=df.parse(kaishi);
			Date end=df.parse(jiesu);
			int re_num=shoujianService.findShoujianNumsByDate(start, end);
			int se_num=paijianService.findPaijianNumsByDate(start, end);
			int re_broke=shoujianService.findShoujianBrokeNumsByDate(start, end);
			int se_broke=paijianService.findPaijianBrokeNumsByDate(start, end);
			Post_workload workload=new Post_workload();
			workload.setPost_re_broke(re_broke);
			workload.setPost_re_num(re_num);
			workload.setPost_se_broke(se_broke);
			workload.setPost_se_num(se_num);
			request.getSession().setAttribute("suanjian", workload);
			request.getSession().setAttribute("start", start);
			request.getSession().setAttribute("end", end);
			return "admin/suanjian";
		}
		
	//手动派件
		@RequestMapping("/shoudong")
		public String shoudong(String se_name,String se_phone,String se_endaddress,int cust_id,Integer post_id,HttpServletRequest request) {
			Customer customer=custService.findCustomerById(cust_id);
			Area area=customer.getCust_area();
			Paijian paijian=new Paijian();
			paijian.setSe_endaddress(se_endaddress);
			paijian.setSe_customer_id(customer);
			paijian.setSe_name(se_name);
			paijian.setSe_phone(se_phone);
			paijian.setSe_stateaddress(area);
			paijian.setSe_startdate(new Date());
			paijian.setSe_status(statusService.findStateById(1));
			Post post=postService.findPostById(post_id);
			paijian.setSe_post_id(post);
			paijianService.savePaijian(paijian);
			return "admin/home";
		}
		
	//查询所有邮差的工作量情况，用直方图显示
		@RequestMapping("/workload")
		public String workload(HttpServletRequest request) {
			List<String> post_names=postService.findPostName();
			List<Integer> workloads=postService.findWorkloads();
			request.getSession().setAttribute("post_names", post_names);
			request.getSession().setAttribute("workloads", workloads);
			return "admin/workload";
		}
		
	//查询某个post的situation
		@RequestMapping("/situation")
		public String situation(int pid,HttpServletRequest request) throws ParseException {
			Post post=postService.findPostById(pid);
			Integer max=situationService.findRecentSituationMaxnumByPostId(pid);
			Post_situation situation=situationService.findRecentPost_situationById(max);
			request.getSession().setAttribute("postS", post);
			if(situation==null) {
				String kaishi="2020-12-01 00:00:00";
				String jiesu="2021-01-01 00:00:00";
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
				Date start=df.parse(kaishi);
				Date end=df.parse(jiesu);
			Integer qing=qingService.findDaysByPostIdByDate(pid, start, end);
			Integer jia=jiaService.findDaysByPostIdByDate(pid, start, end);
			Integer xiu=xiuService.findDaysByPostIdByDate(pid, start, end);
			Integer zai=zaiService.findDaysByPostIdByDate(pid, start, end);
			Post_situation situation2=new Post_situation();
			situation2.setPost(post);
			situation2.setPost_end(end);
			situation2.setPost_jiaban(jia);
			situation2.setPost_qingjia(qing);
			situation2.setPost_start(start);
			situation2.setPost_xiujia(xiu);
			situation2.setPost_zaigang(zai);
			situationService.saveSituation(situation2);
             request.getSession().setAttribute("situation", situation2);
             return "admin/situation";
			}
			request.getSession().setAttribute("situation", situation);
			return "admin/situation";
		}
		
	//修改某个post的工作与休息情况
		@RequestMapping("/upinfo")
		public String upinfo(int pid,int nid) {
			Post post=postService.findPostById(pid);
			post.setPost_work(1);
			postService.savePost(post);
			Zai zai=new Zai();
			zai.setZai_post(post);
			if(nid==0) {
				Integer max=qingService.findMaxnumByPost(pid);
				Qing qing=qingService.findRecentzai(max);
				Date current=qing.getQing_end();
			    Date cDate=Util.date(current, 1);
			    zai.setZai_start(cDate);
			}
			else if(nid==2) {
				Integer max=xiuService.findMaxnumByPost(pid);
				Xiu xiu=xiuService.findRecentXiu(max);
				Date current=xiu.getXiu_end();
				Date cDate=Util.date(current, 1);
				zai.setZai_start(cDate);
			}
			zaiService.saveZai(zai);
			return "admin/youchai";
		}
	
	//跳转审批
		@RequestMapping("/shenpi")
		public String shenpi(HttpServletRequest request) {
			List<Note> notes=noteService.findNotes();
			request.getSession().setAttribute("notes", notes);
			return "admin/shenpi";
		}
	
		//审批
		@RequestMapping("/shen")
		public String shen(int id,int state,int nid,int day) {
			Post post=postService.findPostById(id);
			post.setPost_work(state);
			postService.savePost(post);
			Note note=noteService.findNoteById(nid);
			note.setNote_state(1);
			noteService.saveNote(note);
			Integer max=zaiService.findMaxnumByPost(id);
			Zai zai=zaiService.findRecentzai(max);
			Date start=zai.getZai_end();
			Date end=Util.date(start, day);
			if(state==0) {
				Qing qing=new Qing();
				qing.setQing_start(start);
				qing.setQing_end(end);
				qing.setQing_post(post);
				qingService.saveQing(qing);
				
			}
			else if(state==2) {
				Xiu xiu=new Xiu();
				xiu.setXiu_start(start);
				xiu.setXiu_end(end);
				xiu.setXiu_post(post);
				xiuService.saveXiu(xiu);
			}
			return "admin/home";
		}
		
}
