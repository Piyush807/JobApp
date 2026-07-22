package com.jobapprest.jobapprest.controller;

import com.jobapprest.jobapprest.model.JobPost;
import com.jobapprest.jobapprest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService jobService;

    private final int PAGE_SIZE= 3;

    @GetMapping("jobPosts")
    public Page<JobPost> getAllJobs(@RequestParam(defaultValue = "postId") String sortby, @RequestParam(defaultValue = "0") int page) {
      //  return jobService.findBy(Sort.by(sortby));
        Pageable pageable = PageRequest.of(page, PAGE_SIZE);
        return jobService.getAllJobs(pageable);
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

   @GetMapping("sorted")
    public List<JobPost> getSortedJobs() {
        return jobService.findByOrderByReqExperience();
   }





}
