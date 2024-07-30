package com.example.springbootweb1;

import com.example.springbootweb1.model.JobPost;
import com.example.springbootweb1.service.JobService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private  JobService service;

    @GetMapping({"/", "home"})
    public String home(){
        return "home";
    }
    @GetMapping("addjob")
    public String addjob(){
        return "addjob";
    }
    @PostMapping("handleForm")
    public  String handleForm(@ModelAttribute JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewalljobs(Model model){
        List<JobPost> alljobs = service.getAllJobs();
        model.addAttribute("jobPosts", alljobs);
        return "viewalljobs";
    }
}
