package com.example.webdevhw.services;


import com.example.webdevhw.models.Campaign;
import com.example.webdevhw.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseService {
  @Autowired
  CourseRepository courseRepository;

  @GetMapping("/api/course")
  public Iterable<Campaign> findAllCourses() {
    return courseRepository.findAll();
  }

  @GetMapping("/api/course/{courseId}")
  public Campaign findCourseById(@PathVariable("courseId") int courseId) {
    Optional<Campaign> data = courseRepository.findById(courseId);
    return data.orElse(null);
  }

  @PostMapping("/api/course")
  public Campaign createCourse(@RequestBody Campaign campaign) {
    return courseRepository.save(campaign);
  }

  @DeleteMapping("/api/course/{courseId}")
  public void deleteCourse(@PathVariable("courseId") int id) {
    courseRepository.deleteById(id);
  }

  @PutMapping("/api/course/{courseId}")
  public Campaign updateCourse(@PathVariable("courseId") int courseId, @RequestBody Campaign newCampaign)
          throws Exception  {
    Optional<Campaign> data = courseRepository.findById(courseId);
    if (data.isPresent()) {
      Campaign campaign = data.get();
      if (newCampaign.getTitle() != null){ campaign.setTitle(newCampaign.getTitle());}
      if (newCampaign.getCreated() != null){
        campaign.setCreated(newCampaign.getCreated());}
      if (newCampaign.getModified() != null){
        campaign.setModified(newCampaign.getModified());}
      courseRepository.save(campaign);
      return campaign;
    }
    else{
      throw new Exception("bad");
    }
  }
}
