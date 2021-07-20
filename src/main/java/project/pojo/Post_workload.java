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
@Table(name = "post_workload")
public class Post_workload {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int post_workload_id;
	
	private int post_re_num;
	private int post_se_num;
	private int post_re_broke;
	private int post_se_broke;
	private Date gongzi_start;
	private Date gongzi_end;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
	@JoinColumn(name = "POST",referencedColumnName = "POST_ID")
	private Post post;
	
	public int getPost_workload_id() {
		return post_workload_id;
	}
	public void setPost_workload_id(int post_workload_id) {
		this.post_workload_id = post_workload_id;
	}
	public int getPost_re_num() {
		return post_re_num;
	}
	public void setPost_re_num(int post_re_num) {
		this.post_re_num = post_re_num;
	}
	public int getPost_se_num() {
		return post_se_num;
	}
	public void setPost_se_num(int post_se_num) {
		this.post_se_num = post_se_num;
	}
	public int getPost_re_broke() {
		return post_re_broke;
	}
	public void setPost_re_broke(int post_re_broke) {
		this.post_re_broke = post_re_broke;
	}
	public int getPost_se_broke() {
		return post_se_broke;
	}
	public void setPost_se_broke(int post_se_broke) {
		this.post_se_broke = post_se_broke;
	}
	public Date getGongzi_start() {
		return gongzi_start;
	}
	public void setGongzi_start(Date gongzi_start) {
		this.gongzi_start = gongzi_start;
	}
	public Date getGongzi_end() {
		return gongzi_end;
	}
	public void setGongzi_end(Date gongzi_end) {
		this.gongzi_end = gongzi_end;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
