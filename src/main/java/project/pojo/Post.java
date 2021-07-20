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
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int post_id;
	
	private String post_name;
	private String post_password;
	private int post_work;
	private String post_phone;
	private Integer workload;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Area.class)
	@JoinColumn(name = "POST_AREA",referencedColumnName = "AREA_ID")
	private Area post_area;
	
	
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getPost_password() {
		return post_password;
	}
	public void setPost_password(String post_password) {
		this.post_password = post_password;
	}
	public int getPost_work() {
		return post_work;
	}
	public void setPost_work(int post_work) {
		this.post_work = post_work;
	}
	public String getPost_phone() {
		return post_phone;
	}
	public void setPost_phone(String post_phone) {
		this.post_phone = post_phone;
	}
	public Area getPost_area() {
		return post_area;
	}
	public void setPost_area(Area post_area) {
		this.post_area = post_area;
	}
	public Integer getWorkload() {
		return workload;
	}
	public void setWorkload(Integer workload) {
		this.workload = workload;
	}
	
	
	
	
}
