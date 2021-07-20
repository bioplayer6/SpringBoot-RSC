package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Post_situation;

public interface Post_situationJpa extends JpaRepository<Post_situation,Long> {

	@Query("select w from project.pojo.Post_situation as w where post_situation_id=?1")
	public Post_situation getRecentPost_situationById(Integer max);
	
	@Query("select w from project.pojo.Post_situation as w")
	public List<Post_situation> getPost_situations();
	
	@Query("select max(w.post_situation_id) from project.pojo.Post_situation as w where w.post.post_id=?1")
	public Integer getRecentSituationMaxnumByPostId(Integer post_id);
	
}
