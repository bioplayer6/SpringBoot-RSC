package project.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Xiu;

public interface XiuJpa extends JpaRepository<Xiu,Long>  {

	@Query("select count(w.xiu_id) from project.pojo.Xiu as w where xiu_post.post_id=?1")
	public Integer getDaysByPostId(Integer post_id);
	
	@Query("select count(w.xiu_id) from project.pojo.Xiu as w where xiu_post.post_id=?1 AND (w.xiu_start between ?2 and ?3)")
	public Integer getDaysByPostIdByDate(Integer post_id,Date start,Date end);
	
	@Query("select w from project.pojo.Xiu as w where xiu_id=?1")
	public Xiu getRecentXiu(Integer xiu_id);
	
	@Query("select max(w.xiu_id) from project.pojo.Xiu as w where w.xiu_post.post_id=?1")
	public Integer getMaxnumByPost(Integer post_id);
}
