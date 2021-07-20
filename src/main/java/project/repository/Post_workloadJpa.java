package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Post_workload;

public interface Post_workloadJpa extends JpaRepository<Post_workload,Long> {

	@Query("select w from project.pojo.Post_workload as w where post_workload_id=?1")
	public Post_workload getRecentPost_workloadById(Integer max);
	
	@Query("select w from project.pojo.Post_workload as w")
	public List<Post_workload> getPost_workloads();
	
	@Query("select max(w.post_workload_id) from project.pojo.Post_workload as w where w.post.post_id=?1")
	public Integer getRecentWorkloadMaxnumByPostId(Integer post_id);
	
	
}
