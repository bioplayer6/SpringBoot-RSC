package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Post_situation;
import project.repository.Post_situationJpa;

@Service
public class Post_situationService {

	@Resource
	private Post_situationJpa post_situationJpa;
	
    public Post_situation findRecentPost_situationById(Integer max) {
	return post_situationJpa.getRecentPost_situationById(max);
   }
	
	
	public List<Post_situation> findPost_situations(){
		return post_situationJpa.getPost_situations();
	}
	
	
	public Integer findRecentSituationMaxnumByPostId(Integer post_id) {
		return post_situationJpa.getRecentSituationMaxnumByPostId(post_id);
	}
	
	public Post_situation saveSituation(Post_situation situation) {
		return post_situationJpa.save(situation);
	}
}
