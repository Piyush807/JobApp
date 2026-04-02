package com.jobapprest.jobapprest;

import com.jobapprest.jobapprest.model.JobPost;
import com.jobapprest.jobapprest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobById(@PathVariable("postId") int postId) {
        return jobService.getJobByid(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJobByid(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJOb(@PathVariable int postId) {
        jobService.deleteJob(postId);
        return "Deleted"+postId;
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
    }

    @GetMapping("load")
    public String load() {
        jobService.load();
        return "success";
    }


}
