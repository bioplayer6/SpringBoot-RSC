package project.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Jia;
import project.repository.JiaJpa;

@Service
public class JiaService {

	@Resource
	private JiaJpa jiaJpa;
	
	public Jia saveJia(Jia jia) {
		return jiaJpa.save(jia);
	}
	
	public Integer findDaysByPostId(Integer post_id) {
		return jiaJpa.getDaysByPostId(post_id);
	}
	
	
	public Integer findDaysByPostIdByDate(Integer post_id,Date start,Date end) {
		return jiaJpa.getDaysByPostIdByDate(post_id, start, end);
	}
	
	
	public Jia findRecentzai(Integer zai_id){
		return jiaJpa.getRecentzai(zai_id);
	}
	
	
	public Integer findMaxnumByPost(Integer post_id){
		return jiaJpa.getMaxnumByPost(post_id);
	}
}
