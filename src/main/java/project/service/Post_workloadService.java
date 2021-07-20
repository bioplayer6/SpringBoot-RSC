package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Post_workload;
import project.repository.Post_workloadJpa;

@Service
public class Post_workloadService {

	@Resource
	private Post_workloadJpa post_workloadJpa;
	
	public Post_workload findRecentWorkloadById(Integer id) {
		return post_workloadJpa.getRecentPost_workloadById(id);
	}
	
	public List<Post_workload> findWorkloads(){
		return post_workloadJpa.getPost_workloads();
	}
	
	public Integer findRecentWorkloadMaxnumByPostId(Integer post_id) {
		return post_workloadJpa.getRecentWorkloadMaxnumByPostId(post_id);
	}
	
	public Post_workload saveWorkload(Post_workload workload) {
		return post_workloadJpa.save(workload);
	}
}
