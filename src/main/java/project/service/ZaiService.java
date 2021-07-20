package project.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Zai;
import project.repository.ZaiJpa;

@Service
public class ZaiService {

	@Resource
	private ZaiJpa zaiJpa;
	
	public Zai saveZai(Zai zai) {
		return zaiJpa.save(zai);
	}
	
	public Integer findDaysByPostId(Integer post_id) {
		return zaiJpa.getDaysByPostId(post_id);
	}
	
	
	public Integer findDaysByPostIdByDate(Integer post_id,Date start,Date end){
		return zaiJpa.getDaysByPostIdByDate(post_id, start, end);
	}
	
	
	public Zai findRecentzai(Integer zai_id){
		return zaiJpa.getRecentzai(zai_id);
	}
	
	
	public Integer findMaxnumByPost(Integer post_id){
		return zaiJpa.getMaxnumByPost(post_id);
	}
}
