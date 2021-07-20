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
@Table(name = "note")
public class Note {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int note_id;
	
	private int note_days;
	private int note_status;
	private int note_state;
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = Post.class)
    @JoinColumn(name = "NOTE_POST",referencedColumnName = "POST_ID")
	private Post note_post;

	public int getNote_id() {
		return note_id;
	}

	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}

	public int getNote_days() {
		return note_days;
	}

	public void setNote_days(int note_days) {
		this.note_days = note_days;
	}

	public int getNote_status() {
		return note_status;
	}

	public void setNote_status(int note_status) {
		this.note_status = note_status;
	}

	public Post getNote_post() {
		return note_post;
	}

	public void setNote_post(Post note_post) {
		this.note_post = note_post;
	}

	public int getNote_state() {
		return note_state;
	}

	public void setNote_state(int note_state) {
		this.note_state = note_state;
	}
	
	
}
