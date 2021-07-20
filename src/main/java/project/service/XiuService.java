package project.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Xiu;
import project.repository.XiuJpa;

@Service
public class XiuService {

	@Resource
	private XiuJpa xiuJpa;
	

	public Xiu saveXiu(Xiu xiu) {
		return xiuJpa.save(xiu);
	}
	public Integer findDaysByPostId(Integer post_id) {
		return xiuJpa.getDaysByPostId(post_id);
	}
	

	public Integer findDaysByPostIdByDate(Integer post_id,Date start,Date end){
		return xiuJpa.getDaysByPostIdByDate(post_id, start, end);
	}
	
	public Xiu findRecentXiu(Integer xiu_id){
		return xiuJpa.getRecentXiu(xiu_id);
	}
	
	public Integer findMaxnumByPost(Integer post_id){
		return xiuJpa.getMaxnumByPost(post_id);
	}
}
