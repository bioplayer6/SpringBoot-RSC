package project.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Index;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.pojo.Customer;
import project.pojo.Paijian;
import project.pojo.Post;
import project.pojo.Post_workload;
import project.pojo.Shoujian;
import project.service.AreaService;
import project.service.CustomerService;
import project.service.PaijianService;
import project.service.PostService;
import project.service.ShoujianService;
import project.service.StatusService;

@Controller
@RequestMapping("/cust")
public class CustomerController {

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
	
	//跳转home页面
		@RequestMapping("/home")
		public String home() {
			return "cust/home";
		}
		
	//跳转info页面
		@RequestMapping("/info")
		public String info() {
			return "cust/info";
		}
		
	//跳转登录页面
	@RequestMapping("/index")
	public String index() {
		return "cust/login";
	}
	
	//跳转注册页面
	@RequestMapping("/register")
	public String Index() {
		return "cust/register";
	}
	
	//跳转寄件页面
		@RequestMapping("/send")
		public String send() {
			return "cust/jijian";
		}
		
	//注册
	@RequestMapping("/regist")
	public String register(String name, String password, String address, String phone, Integer id) {
		Customer customer=custService.register(name, password, address, phone, id);
		return "cust/login";
	}
	
	//登录
	@RequestMapping("/login")
	public String login(String loginName, String password, HttpServletRequest request) {
		int result=custService.findCustomer(loginName, password, request);
		if(result==0)
			return "cust/errorlogin";
		else {
			return "cust/index";
		}
	}
	
	//寄件
	@RequestMapping("/jijian")
	public String jijian(String re_name, String re_phone, String re_endaddress, HttpServletRequest request) {
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		Shoujian shoujian=new Shoujian();
		shoujian.setRe_endaddress(re_endaddress);
		shoujian.setRe_startdate(new Date());
		shoujian.setRe_name(re_name);
		shoujian.setRe_phone(re_phone);
		shoujian.setRe_stateaddress(customer.getCust_area());
		shoujian.setRe_customer_id(customer);
		List<Post> posts=postService.findAppropriatePost(customer.getCust_area());
		if(posts.isEmpty()) {
			return "cust/home";
		}
		Post post=posts.get(posts.size()-1);
		shoujian.setRe_post_id(post);
		shoujian.setRe_status(statusService.findStateById(1));
		shoujianService.saveShoujian(shoujian);
		return "cust/home";
	}
	
	//收件
	@RequestMapping("/shoujian")
	public String Shoujian(HttpServletRequest request) {
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		List<Shoujian> shoujians=shoujianService.getShoujiansByCustId(customer.getCust_id());
		request.getSession().setAttribute("shoujians", shoujians);
		return "cust/shoujian";
	}
	
	//派件
	@RequestMapping("/paijian")
	public String paijian(HttpServletRequest request) {
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		List<Paijian> paijians=paijianService.getPaijiansByCustId(customer.getCust_id());
		request.getSession().setAttribute("paijians", paijians);
		return "cust/paijian";
	}
}
