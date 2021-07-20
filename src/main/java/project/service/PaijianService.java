package project.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Paijian;
import project.repository.PaijianJpa;

@Service
public class PaijianService {

	@Resource
	private PaijianJpa paijianJpa;
	
	public Paijian savePaijian(Paijian paijian) {
		return paijianJpa.save(paijian);
	}
	
	public List<Paijian> findPaijiansByPostId(Integer post_id){
		return paijianJpa.getPaijiansByPostId(post_id);
	}
	
	public List<Paijian> getPaijians(){
		return paijianJpa.getPaijians();
	}
	public Paijian findPaijianById(Integer se_id) {
		return paijianJpa.getPaijianById(se_id);
	}
	
	public List<Paijian> getPaijiansByCustId(Integer cust_id){
		return paijianJpa.getPaijiansByCustId(cust_id);
	}
	public Integer findPaijianNumsByDate(Date start,Date end) {
		return paijianJpa.getPaijianNumsByDate(start, end);
	}
	
	public Integer findPaijianBrokeNumsByDate(Date start,Date end) {
		return paijianJpa.getPaijianBrokeNumsByDate(start, end);
	}
	
	public Integer findPaijianNumsByDateById(Date start,Date end,Integer post_id) {
		return paijianJpa.getPaijianNumsByDateById(start, end, post_id);
	}
	
	public Integer findPaijianBrokeNumsByDateById(Date start,Date end,Integer post_id) {
		return paijianJpa.getPaijianBrokeNumsByDateById(start, end, post_id);
	}
}
