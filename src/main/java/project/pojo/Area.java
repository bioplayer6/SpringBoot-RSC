package project.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int area_id;
	
	public int getArea_id() {
		return area_id;
	}
	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}
	public String getArea_qu() {
		return area_qu;
	}
	public void setArea_qu(String area_qu) {
		this.area_qu = area_qu;
	}
	public String getArea_town() {
		return area_town;
	}
	public void setArea_town(String area_town) {
		this.area_town = area_town;
	}
	private String area_qu;
	private String area_town;
}
