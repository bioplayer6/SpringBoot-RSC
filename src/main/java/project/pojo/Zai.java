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
@Table(name = "zai")
public class Zai {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int zai_id;
	
	private Date zai_start;
	private Date zai_end;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
    @JoinColumn(name = "ZAI_POST",referencedColumnName = "POST_ID")
	private Post zai_post;

	public int getZai_id() {
		return zai_id;
	}

	public void setZai_id(int zai_id) {
		this.zai_id = zai_id;
	}

	public Date getZai_start() {
		return zai_start;
	}

	public void setZai_start(Date zai_start) {
		this.zai_start = zai_start;
	}

	public Date getZai_end() {
		return zai_end;
	}

	public void setZai_end(Date zai_end) {
		this.zai_end = zai_end;
	}

	public Post getZai_post() {
		return zai_post;
	}

	public void setZai_post(Post zai_post) {
		this.zai_post = zai_post;
	}
	
	
}
