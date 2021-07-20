package project.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Jia;

public interface JiaJpa extends JpaRepository<Jia,Long>  {

	@Query("select count(w.jia_id) from project.pojo.Jia as w where jia_post.post_id=?1")
	public Integer getDaysByPostId(Integer post_id);
	
	@Query("select count(w.jia_id) from project.pojo.Jia as w where jia_post.post_id=?1 AND (w.jia_start between ?2 and ?3)")
	public Integer getDaysByPostIdByDate(Integer post_id,Date start,Date end);
	
	@Query("select w from project.pojo.Jia as w where jia_id=?1")
	public Jia getRecentzai(Integer zai_id);
	
	@Query("select max(w.jia_id) from project.pojo.Jia as w where w.jia_post.post_id=?1")
	public Integer getMaxnumByPost(Integer post_id);
}
