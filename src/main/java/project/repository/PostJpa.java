package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Area;
import project.pojo.Post;

public interface PostJpa extends JpaRepository<Post,Long> {

	//查询在合适区域内以工作量少升序排序的邮差们
	@Query("select p from project.pojo.Post as p where post_area = ?1 and post_work in(1,3) order by workload desc")
    public List<Post> getAppropriatePost(Area area);

	//通过邮差名和密码查询邮差
    @Query("select p from project.pojo.Post as p where post_name = ?1 and post_password = ?2")
    public Post getPost(String poname,String popassword);

    //查询所有邮差
    @Query("select p from project.pojo.Post as p")
    public List<Post> getAllPost();

    //通过id查询邮差
    @Query("select p from project.pojo.Post as p where post_id = ?1")
    public Post findPostById(Integer poid);

    //查询所有邮差名字
    @Query("select p.post_name from project.pojo.Post as p")
    public List<String> getPostName();
    
    //查询所有邮差本月的工作量
    @Query("select p.workload from project.pojo.Post as p")
    public List<Integer> getWorkloads();

  	
}
