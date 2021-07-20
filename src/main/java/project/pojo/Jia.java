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
@Table(name = "jia")
public class Jia {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int jia_id;
	
	private Date jia_start;
	private Date jia_end;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
    @JoinColumn(name = "JIA_POST",referencedColumnName = "POST_ID")
	private Post jia_post;

	public int getJia_id() {
		return jia_id;
	}

	public void setJia_id(int jia_id) {
		this.jia_id = jia_id;
	}

	public Date getJia_start() {
		return jia_start;
	}

	public void setJia_start(Date jia_start) {
		this.jia_start = jia_start;
	}

	public Date getJia_end() {
		return jia_end;
	}

	public void setJia_end(Date jia_end) {
		this.jia_end = jia_end;
	}

	public Post getJia_post() {
		return jia_post;
	}

	public void setJia_post(Post jia_post) {
		this.jia_post = jia_post;
	}
	
	
}