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
@Table(name = "qing")
public class Qing {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int qing_id;
	
	private Date qing_start;
	private Date qing_end;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
    @JoinColumn(name = "QING_POST",referencedColumnName = "POST_ID")
	private Post qing_post;

	public int getQing_id() {
		return qing_id;
	}

	public void setQing_id(int qing_id) {
		this.qing_id = qing_id;
	}

	public Date getQing_start() {
		return qing_start;
	}

	public void setQing_start(Date qing_start) {
		this.qing_start = qing_start;
	}

	public Date getQing_end() {
		return qing_end;
	}

	public void setQing_end(Date qing_end) {
		this.qing_end = qing_end;
	}

	public Post getQing_post() {
		return qing_post;
	}

	public void setQing_post(Post qing_post) {
		this.qing_post = qing_post;
	}
	
	
}
