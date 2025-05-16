package com.example.jpaintro.service;
import com.example.jpaintro.model.*;
import com.example.jpaintro.repo.JobRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {


    
    @Autowired
    private JobRepo repo;

    public void addjob(JobPost jobPost){
        repo.save(jobPost);
    }

    public JobPost getjob(int PostId){

        return repo.findById(PostId).orElse(new JobPost());


    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
       
        
    }

    
	public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
		
	}

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

}
