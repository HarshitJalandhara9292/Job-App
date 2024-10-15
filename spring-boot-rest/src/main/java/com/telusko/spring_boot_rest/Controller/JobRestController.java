package com.telusko.spring_boot_rest.Controller;

import com.telusko.spring_boot_rest.Service.JobService;
import com.telusko.spring_boot_rest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping(path = "/JobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    public String getJobPosts() {
        return "JobPosts";
    }

    @GetMapping("/JobPosts/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @GetMapping("/JobPosts/Keyword/{Keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("Keyword") String Keyword){
       return service.search(Keyword);

    }

    @PostMapping("/JobPosts")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJobPost(jobPost);
        return jobPost;
    }

    @PutMapping("/JobPosts")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/JobPosts/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("/load")
    public String loadData() {

        service.load();
        return "success";
    }
}
