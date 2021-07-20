package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Status;

public interface StatusJpa  extends JpaRepository<Status,Long> {

	@Query("select w from project.pojo.Status as w where st_id=?1")
	public Status getStatusById(Integer id);
	
	@Query("select w from project.pojo.Status as w where st_describe=?1")
	public List<Status> getStatusByDesc(String desc);
}
