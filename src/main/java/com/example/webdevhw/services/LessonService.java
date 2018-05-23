package com.example.webdevhw.services;
import com.example.webdevhw.models.Lesson;
import com.example.webdevhw.models.Module;
import com.example.webdevhw.repositories.LessonRepository;
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
public class LessonService {
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  ModuleRepository moduleRepository;

  @PostMapping("/api/module/{moduleId}/lesson")
  public Lesson createLesson(
          @PathVariable("moduleId") int moduleId,
          @RequestBody Lesson newLesson) {
    Optional<Module> data = moduleRepository.findById(moduleId);

    if(data.isPresent()) {
      Module module = data.get();
      newLesson.setModule(module);
      return lessonRepository.save(newLesson);
    }
    return null;
  }

  @GetMapping("/api/module/{moduleId}/lesson")
  public List<Lesson> findAllLessonsForCourse(
          @PathVariable("moduleId") int moduleId) {
    Optional<Module> data = moduleRepository.findById(moduleId);
    if(data.isPresent()) {
      Module module = data.get();
      return module.getLessons();
    }
    return null;
  }
}
