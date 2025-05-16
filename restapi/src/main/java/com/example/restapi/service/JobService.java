package com.example.restapi.service;
import com.example.restapi.model.*;
import com.example.restapi.repo.JobRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {


    
    @Autowired
    private JobRepo repo;

    public void addjob(JobPost jobPost){
        repo.addJob(jobPost);
    }

    public JobPost getjob(int PostId){

        return repo.getjob(PostId);

    }

    public List<JobPost> getAllJobs(){
        return repo.getAllJobs();
       
        
    }

    
	public void updateJob(JobPost jobPost) {
	repo.updateJob(jobPost);
		
	}

}
