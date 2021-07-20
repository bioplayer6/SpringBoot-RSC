package project.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import project.pojo.Area;
import project.pojo.Post;
import project.repository.PostJpa;

@Service
public class PostService {

	@Resource
	private PostJpa postJpa;
	
	public Post savePost(Post post) {
		return postJpa.save(post);
	}
	public List<Post> findAppropriatePost(Area area){
		return postJpa.getAppropriatePost(area);
	}
	
	public int getPost(String loginame, String password, HttpServletRequest request){
        Post post = postJpa.getPost(loginame, password);
        request.getSession().setAttribute("post",post);
        if (post==null){
            return 0;
        }
        return 1;
    }
	
	 public List<Post> findAllPost(){
		 return postJpa.getAllPost();
	 }
	 
	 public Post findPostById(Integer poid) {
		 return postJpa.findPostById(poid);
	 }
	 
	 public List<String> findPostName(){
		 return postJpa.getPostName();
	 }
	  
	 public List<Integer> findWorkloads(){
		 return postJpa.getWorkloads();
	 }
	 

	 
	 
}
