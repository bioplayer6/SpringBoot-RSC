package project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Shoujian;

public interface ShoujianJpa extends JpaRepository<Shoujian,Long>  {
	
	@Query("select w from project.pojo.Shoujian as w where re_post_id.post_id=?1")
	public List<Shoujian> getShoujiansByPostId(Integer post_id);
	
	@Query("select w from project.pojo.Shoujian as w")
	public List<Shoujian> getShoujians();
	
	@Query("select w from project.pojo.Shoujian as w where re_id=?1")
	public Shoujian getShoujianById(Integer re_id);
	
	@Query("select w from project.pojo.Shoujian as w where re_customer_id.cust_id=?1")
	public List<Shoujian> getShoujiansByCustId(Integer cust_id);
	
	@Query("select count(w.re_status) from project.pojo.Shoujian as w where re_status.st_id in (1,2,3) AND (re_startdate between ?1 and ?2)")
	public Integer getShoujianNumsByDate(Date start,Date end);
	
	@Query("select count(w.re_status) from project.pojo.Shoujian as w where re_status.st_id not in (1,2,3) AND (re_startdate between ?1 and ?2)")
	public Integer getShoujianBrokeNumsByDate(Date start,Date end);
	
	@Query("select count(w.re_status) from project.pojo.Shoujian as w where re_status.st_id in (1,2,3) AND (re_startdate between ?1 and ?2) AND re_post_id.post_id=?3")
	public Integer getShoujianNumsByDateById(Date start,Date end,Integer post_id);
	
	@Query("select count(w.re_status) from project.pojo.Shoujian as w where re_status.st_id not in (1,2,3) AND (re_startdate between ?1 and ?2) AND re_post_id.post_id=?3")
	public Integer getShoujianBrokeNumsByDateById(Date start,Date end,Integer post_id);
}
