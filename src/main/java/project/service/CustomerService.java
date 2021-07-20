package project.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import project.pojo.Area;
import project.pojo.Customer;
import project.repository.CustomerJpa;

@Service
public class CustomerService {

	@Resource
	private CustomerJpa customerJpa;
	
	@Resource
	private AreaService areaService;
	
	public Customer saveCustomer(Customer customer) {
		return customerJpa.save(customer);
	}
	
	public List<Customer> findAllCustomers(){
		return customerJpa.getCustomers();
	}
	
	public Customer findCustomerById(Integer id){
		return customerJpa.getCustomerById(id);
	}
	
	public Customer register(String name, String password, String address, String phone, Integer id) {
		Customer customer=new Customer();
		customer.setCust_name(name);
		customer.setCust_address(address);
		customer.setCust_phone(phone);
		customer.setCust_password(password);
		Area area=areaService.findAreaById(id);
		customer.setCust_area(area);
		return customerJpa.save(customer);
		
	}
	
	public int findCustomer(String loginame, String password, HttpServletRequest request){
        Customer customer = customerJpa.getCustomer(loginame, password);
        request.getSession().setAttribute("customer",customer);
        if (customer==null){
            return 0;
        }
        return 1;
    }
}
