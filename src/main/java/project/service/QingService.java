package project.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Qing;
import project.repository.QingJpa;

@Service
public class QingService {

	@Resource
	private QingJpa qingJpa;
	
	public Qing saveQing(Qing qing) {
		return qingJpa.save(qing);
	}
	
	public Integer findDaysByPostId(Integer post_id) {
		return qingJpa.getDaysByPostId(post_id);
	}
	
	public Integer findDaysByPostIdByDate(Integer post_id,Date start,Date end){
		return qingJpa.getDaysByPostIdByDate(post_id, start, end);
	}
	
	public Qing findRecentzai(Integer zai_id){
		return qingJpa.getRecentzai(zai_id);
	}
	
	public Integer findMaxnumByPost(Integer post_id){
		return qingJpa.getMaxnumByPost(post_id);
	}
}
