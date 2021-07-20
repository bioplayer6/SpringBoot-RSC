package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Customer;

public interface CustomerJpa extends JpaRepository<Customer,Long> {

	//通过顾客名和密码返回顾客对象
	@Query("select w from project.pojo.Customer as w where cust_name=?1 and cust_password=?2")
	public Customer getCustomer(String username,String password);
	
	//通过id返回顾客
	@Query("select w from project.pojo.Customer as w where cust_id=?1")
	public Customer getCustomerById(Integer id);
	
	//返回所有顾客对象
	@Query("select w from project.pojo.Customer as w")
	public List<Customer> getCustomers();
	
}
