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
@Table(name = "xiu")
public class Xiu {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int xiu_id;
	
	private Date xiu_start;
	private Date xiu_end;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
    @JoinColumn(name = "XIU_POST",referencedColumnName = "POST_ID")
	private Post xiu_post;

	public int getXiu_id() {
		return xiu_id;
	}

	public void setXiu_id(int xiu_id) {
		this.xiu_id = xiu_id;
	}

	public Date getXiu_start() {
		return xiu_start;
	}

	public void setXiu_start(Date xiu_start) {
		this.xiu_start = xiu_start;
	}

	public Date getXiu_end() {
		return xiu_end;
	}

	public void setXiu_end(Date xiu_end) {
		this.xiu_end = xiu_end;
	}

	public Post getXiu_post() {
		return xiu_post;
	}

	public void setXiu_post(Post xiu_post) {
		this.xiu_post = xiu_post;
	}
	
	
}