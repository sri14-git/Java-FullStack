package com.example.jobapp.service;
import com.example.jobapp.model.*;
import com.example.jobapp.repo.JobRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {


    
    @Autowired
    private JobRepo service;

    public void addjob(JobPost jobPost){
         service.addJob(jobPost);
        

    }

    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
       
        
    }

}
