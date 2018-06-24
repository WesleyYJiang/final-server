package com.example.webdevhw.services;
import com.example.webdevhw.models.Campaign;
import com.example.webdevhw.models.Action;
import com.example.webdevhw.repositories.CourseRepository;
import com.example.webdevhw.repositories.ModuleRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ModuleService {
  @Autowired
  CourseRepository courseRepository;

  @Autowired
  ModuleRepository moduleRepository;

  @PostMapping("/api/course/{courseId}/module")
  public Action createModule(
          @PathVariable("courseId") int courseId,
          @RequestBody Action newAction) {
    Optional<Campaign> data = courseRepository.findById(courseId);

    if(data.isPresent()) {
      Campaign campaign = data.get();
      newAction.setCampaign(campaign);
      return moduleRepository.save(newAction);
    }
    return null;
  }

  @GetMapping("/api/course/{courseId}/module")
  public List<Action> findAllModulesForCourse(
          @PathVariable("courseId") int courseId) {
    Optional<Campaign> data = courseRepository.findById(courseId);
    if(data.isPresent()) {
      Campaign campaign = data.get();
      return campaign.getActions();
    }
    return null;
  }

  @DeleteMapping("/api/module/{moduleId}")
  public void deleteModule(@PathVariable("moduleId") int moduleId)
  {
    moduleRepository.deleteById(moduleId);
  }

  @GetMapping("/api/module")
  public List<Action> findAllModules()
  {
    return (List<Action>) moduleRepository.findAll();
  }
}
