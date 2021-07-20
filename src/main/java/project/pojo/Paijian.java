package project.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paijian")
public class Paijian {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int se_id;
	
	private String se_name;
	private String se_phone;
	private Date se_startdate;
	private Date se_enddate;
	private String se_endaddress;
	private int se_num;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Area.class)
	@JoinColumn(name = "SE_STATEADDRESS",referencedColumnName = "AREA_ID")
	private Area se_stateaddress;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Status.class)
	@JoinColumn(name = "SE_STATUS",referencedColumnName = "ST_ID")
	private Status se_status;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Customer.class)
	@JoinColumn(name = "SE_CUSTOMER_ID",referencedColumnName = "CUST_ID")
	private Customer se_customer_id;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
	@JoinColumn(name = "SE_POST_ID",referencedColumnName = "POST_ID")
	private Post se_post_id;
	
	public int getSe_id() {
		return se_id;
	}
	public void setSe_id(int se_id) {
		this.se_id = se_id;
	}
	public String getSe_name() {
		return se_name;
	}
	public void setSe_name(String se_name) {
		this.se_name = se_name;
	}
	public String getSe_phone() {
		return se_phone;
	}
	public void setSe_phone(String se_phone) {
		this.se_phone = se_phone;
	}
	public Date getSe_startdate() {
		return se_startdate;
	}
	public void setSe_startdate(Date se_startdate) {
		this.se_startdate = se_startdate;
	}
	public Date getSe_enddate() {
		return se_enddate;
	}
	public void setSe_enddate(Date se_enddate) {
		this.se_enddate = se_enddate;
	}
	public String getSe_endaddress() {
		return se_endaddress;
	}
	public void setSe_endaddress(String se_endaddress) {
		this.se_endaddress = se_endaddress;
	}
	public Area getSe_stateaddress() {
		return se_stateaddress;
	}
	public void setSe_stateaddress(Area se_stateaddress) {
		this.se_stateaddress = se_stateaddress;
	}
	public Status getSe_status() {
		return se_status;
	}
	public void setSe_status(Status se_status) {
		this.se_status = se_status;
	}
	public Customer getSe_customer_id() {
		return se_customer_id;
	}
	public void setSe_customer_id(Customer se_customer_id) {
		this.se_customer_id = se_customer_id;
	}
	public Post getSe_post_id() {
		return se_post_id;
	}
	public void setSe_post_id(Post se_post_id) {
		this.se_post_id = se_post_id;
	}
	public int getSe_num() {
		return se_num;
	}
	public void setSe_num(int se_num) {
		this.se_num = se_num;
	}
	
	
	
	
	
}
