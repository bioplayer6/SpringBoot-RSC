package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Admin;


public interface AdminJpa extends JpaRepository<Admin,Long>{
	
	//通过管理员用户名和密码返回管理员对象
	@Query("select w from project.pojo.Admin as w where admin_username=?1 and admin_password=?2")
	public Admin getAdmin(String username,String password);

}
