package project.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Shoujian;
import project.repository.ShoujianJpa;

@Service
public class ShoujianService {

	@Resource
	private ShoujianJpa shoujianJpa;
	
	public Shoujian saveShoujian(Shoujian shoujian) {
		return shoujianJpa.save(shoujian);
	}
	
	public List<Shoujian> findShoujiansByPostId(Integer post_id){
		return shoujianJpa.getShoujiansByPostId(post_id);
	}
	
	public List<Shoujian> getShoujians(){
		return shoujianJpa.getShoujians();
	}
	public Shoujian findShoujianById(Integer re_id) {
		return shoujianJpa.getShoujianById(re_id);
	}
	
	public List<Shoujian> getShoujiansByCustId(Integer cust_id){
		return shoujianJpa.getShoujiansByCustId(cust_id);
	}
	public Integer findShoujianNumsByDate(Date start,Date end) {
		return shoujianJpa.getShoujianNumsByDate(start, end);
	}
	
	public Integer findShoujianBrokeNumsByDate(Date start,Date end) {
		return shoujianJpa.getShoujianBrokeNumsByDate(start, end);
	}
	
	public Integer findShoujianNumsByDateById(Date start,Date end,Integer post_id) {
		return shoujianJpa.getShoujianNumsByDateById(start, end, post_id);
	}
	
	public Integer findShoujianBrokeNumsByDateById(Date start,Date end,Integer post_id) {
		return shoujianJpa.getShoujianBrokeNumsByDateById(start, end, post_id);
	}
}
