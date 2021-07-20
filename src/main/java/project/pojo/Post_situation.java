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
@Table(name = "post_situation")
public class Post_situation {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int post_situation_id;
	
	private int post_zaigang;
	private int post_jiaban;
	private int post_qingjia;
	private int post_xiujia;
	private Date post_start;
	private Date post_end;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
	@JoinColumn(name = "POST",referencedColumnName = "POST_ID")
	private Post post;
	
	public int getPost_situation_id() {
		return post_situation_id;
	}
	public void setPost_situation_id(int post_situation_id) {
		this.post_situation_id = post_situation_id;
	}
	public int getPost_zaigang() {
		return post_zaigang;
	}
	public void setPost_zaigang(int post_zaigang) {
		this.post_zaigang = post_zaigang;
	}
	public int getPost_jiaban() {
		return post_jiaban;
	}
	public void setPost_jiaban(int post_jiaban) {
		this.post_jiaban = post_jiaban;
	}
	public int getPost_qingjia() {
		return post_qingjia;
	}
	public void setPost_qingjia(int post_qingjia) {
		this.post_qingjia = post_qingjia;
	}
	public int getPost_xiujia() {
		return post_xiujia;
	}
	public void setPost_xiujia(int post_xiujia) {
		this.post_xiujia = post_xiujia;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Date getPost_start() {
		return post_start;
	}
	public void setPost_start(Date post_start) {
		this.post_start = post_start;
	}
	public Date getPost_end() {
		return post_end;
	}
	public void setPost_end(Date post_end) {
		this.post_end = post_end;
	}
	
	
	
}
