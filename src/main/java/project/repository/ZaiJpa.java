package project.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Zai;

public interface ZaiJpa extends JpaRepository<Zai,Long> {

	@Query("select count(w.zai_id) from project.pojo.Zai as w where zai_post.post_id=?1")
	public Integer getDaysByPostId(Integer post_id);
	
	@Query("select count(w.zai_id) from project.pojo.Zai as w where zai_post.post_id=?1 AND (w.zai_start between ?2 and ?3)")
	public Integer getDaysByPostIdByDate(Integer post_id,Date start,Date end);
	
	@Query("select w from project.pojo.Zai as w where zai_id=?1")
	public Zai getRecentzai(Integer zai_id);
	
	@Query("select max(w.zai_id) from project.pojo.Zai as w where w.zai_post.post_id=?1")
	public Integer getMaxnumByPost(Integer post_id);
}
