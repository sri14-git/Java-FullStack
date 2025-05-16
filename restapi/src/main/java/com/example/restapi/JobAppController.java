package com.example.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.model.JobPost;
import com.example.restapi.service.JobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class JobAppController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();

    }

    @GetMapping("jobPost/{PostId}")
    public JobPost getMethodName(@PathVariable int PostId) {
        return service.getjob(PostId);
    }
    

    @PostMapping("addjob")
    public void addjob(@RequestBody JobPost jobPost) {
        service.addjob(jobPost);
    }
    
    @PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getjob(jobPost.getPostId());
	}



}
