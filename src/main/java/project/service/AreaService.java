package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Area;
import project.repository.AreaJpa;

@Service
public class AreaService {

	@Resource
	private AreaJpa areaJpa;
	
	public List<Area> findAllAreas(){
		return areaJpa.getAllAreas();
	}
	
	public Area findAreaById(Integer id) {
		return areaJpa.getAreaById(id);
	}
	
	public List<String> findArea_qu(){
		return areaJpa.getArea_qu();
	}
	
	public List<Area> findAreasByQu(String area_qu){
		return areaJpa.getAreasByQu(area_qu);
	}
}
