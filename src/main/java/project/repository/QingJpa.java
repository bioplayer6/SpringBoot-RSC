package project.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Qing;


public interface QingJpa extends JpaRepository<Qing,Long> {

	@Query("select count(w.qing_id) from project.pojo.Qing as w where qing_post.post_id=?1")
	public Integer getDaysByPostId(Integer post_id);
	
	@Query("select count(w.qing_id) from project.pojo.Qing as w where qing_post.post_id=?1 AND (w.qing_start between ?2 and ?3)")
	public Integer getDaysByPostIdByDate(Integer post_id,Date start,Date end);
	
	@Query("select w from project.pojo.Qing as w where qing_id=?1")
	public Qing getRecentzai(Integer zai_id);
	
	@Query("select max(w.qing_id) from project.pojo.Qing as w where w.qing_post.post_id=?1")
	public Integer getMaxnumByPost(Integer post_id);

}
