package project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import project.pojo.Status;
import project.repository.StatusJpa;

@Service
public class StatusService {

	@Resource
	private StatusJpa statusJpa;
	
	public Status findStateById(Integer id){
        return statusJpa.getStatusById(id);
    }

    public List<Status> findStatusByDesc(String stdescribe){
        return statusJpa.getStatusByDesc(stdescribe);
    }
}
