package com.example.springbootweb1.service;

import com.example.springbootweb1.model.JobPost;
import com.example.springbootweb1.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepo service;

    public void addJob(JobPost jobPost){
        service.addJob(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
}
