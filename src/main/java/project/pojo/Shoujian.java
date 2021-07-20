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
@Table(name = "shoujian")
public class Shoujian {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int re_id;
	
	private Date re_startdate;
	private Date re_enddate;
	private String re_phone;
	private String re_endaddress;
	private String re_name;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Area.class)
	@JoinColumn(name = "RE_STATEADDRESS",referencedColumnName = "AREA_ID")
	private Area re_stateaddress;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Status.class)
	@JoinColumn(name = "RE_STATUS",referencedColumnName = "ST_ID")
	private Status re_status;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Customer.class)
	@JoinColumn(name = "RE_CUSTOMER_ID",referencedColumnName = "CUST_ID")
	private Customer re_customer_id;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
	@JoinColumn(name = "RE_POST_ID",referencedColumnName = "POST_ID")
	private Post re_post_id;
	
	
	public int getRe_id() {
		return re_id;
	}
	public void setRe_id(int re_id) {
		this.re_id = re_id;
	}
	public Date getRe_startdate() {
		return re_startdate;
	}
	public void setRe_startdate(Date re_startdate) {
		this.re_startdate = re_startdate;
	}
	public Date getRe_enddate() {
		return re_enddate;
	}
	public void setRe_enddate(Date re_enddate) {
		this.re_enddate = re_enddate;
	}
	public String getRe_phone() {
		return re_phone;
	}
	public void setRe_phone(String re_phone) {
		this.re_phone = re_phone;
	}
	public String getRe_endaddress() {
		return re_endaddress;
	}
	public void setRe_endaddress(String re_endaddress) {
		this.re_endaddress = re_endaddress;
	}
	public String getRe_name() {
		return re_name;
	}
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	public Area getRe_stateaddress() {
		return re_stateaddress;
	}
	public void setRe_stateaddress(Area re_stateaddress) {
		this.re_stateaddress = re_stateaddress;
	}
	public Status getRe_status() {
		return re_status;
	}
	public void setRe_status(Status re_status) {
		this.re_status = re_status;
	}
	public Customer getRe_customer_id() {
		return re_customer_id;
	}
	public void setRe_customer_id(Customer re_customer_id) {
		this.re_customer_id = re_customer_id;
	}
	public Post getRe_post_id() {
		return re_post_id;
	}
	public void setRe_post_id(Post re_post_id) {
		this.re_post_id = re_post_id;
	}
	
	
	
	
}
