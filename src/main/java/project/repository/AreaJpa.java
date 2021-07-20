package project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.pojo.Area;

public interface AreaJpa extends JpaRepository<Area,Long>{
	
	//查询所有区域
	@Query("select w from project.pojo.Area as w")
	public List<Area> getAllAreas();
	
	//通过id查询所在的区域
	@Query("select w from project.pojo.Area as w where area_id = ?1")
	public Area getAreaById(Integer id);	
	
	//通过什么区返回区域对象们
	@Query("select w from project.pojo.Area as w where area_qu=?1")
	public List<Area> getAreasByQu(String area_qu);
	
	//返回所有区保存在一个list对象
	@Query("select distinct area_qu from project.pojo.Area")
	public List<String> getArea_qu();

}
