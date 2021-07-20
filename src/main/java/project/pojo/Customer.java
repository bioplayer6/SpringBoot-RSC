package project.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int cust_id;
	
	private String cust_name;
    private String cust_password;
    private String cust_address;
    private String cust_phone;
    
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Area.class)
    @JoinColumn(name = "CUST_AREA",referencedColumnName = "AREA_ID")
    private Area cust_area;

	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_password() {
		return cust_password;
	}
	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public Area getCust_area() {
		return cust_area;
	}
	public void setCust_area(Area cust_area) {
		this.cust_area = cust_area;
	}
	
	
    
}
