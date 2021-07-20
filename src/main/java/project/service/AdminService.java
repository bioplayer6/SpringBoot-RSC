package project.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import project.pojo.Admin;
import project.repository.AdminJpa;

@Service
public class AdminService {

	@Resource
	private AdminJpa adminJpa;
	
	 public int findAdmin(String loginame, String password, HttpServletRequest request){
	        Admin admin = adminJpa.getAdmin(loginame, password);
	        request.getSession().setAttribute("admin",admin);
	        if (admin==null){
	            return 0;
	        }
	        return 1;
	    }
}
