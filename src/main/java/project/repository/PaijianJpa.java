package project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Paijian;

public interface PaijianJpa extends JpaRepository<Paijian,Long> {

	@Query("select w from project.pojo.Paijian as w where se_post_id.post_id=?1")
	public List<Paijian> getPaijiansByPostId(Integer post_id);
	
	@Query("select w from project.pojo.Paijian as w")
	public List<Paijian> getPaijians();
	
	@Query("select w from project.pojo.Paijian as w where se_id=?1")
	public Paijian getPaijianById(Integer se_id);
	
	@Query("select w from project.pojo.Paijian as w where se_customer_id.cust_id=?1")
	public List<Paijian> getPaijiansByCustId(Integer cust_id);
	
	@Query("select count(w.se_status) from project.pojo.Paijian as w where se_status.st_id in (1,2,3) AND (se_startdate between ?1 and ?2)")
	public Integer getPaijianNumsByDate(Date start,Date end);
	
	@Query("select count(w.se_status) from project.pojo.Paijian as w where se_status.st_id not in (1,2,3) AND (se_startdate between ?1 and ?2)")
	public Integer getPaijianBrokeNumsByDate(Date start,Date end);
	
	@Query("select count(w.se_status) from project.pojo.Paijian as w where se_status.st_id in (1,2,3) AND (se_startdate between ?1 and ?2) AND se_post_id.post_id=?3")
	public Integer getPaijianNumsByDateById(Date start,Date end,Integer post_id);
	
	@Query("select count(w.se_status) from project.pojo.Paijian as w where se_status.st_id not in (1,2,3) AND (se_startdate between ?1 and ?2) AND se_post_id.post_id=?3")
	public Integer getPaijianBrokeNumsByDateById(Date start,Date end,Integer post_id);
}
