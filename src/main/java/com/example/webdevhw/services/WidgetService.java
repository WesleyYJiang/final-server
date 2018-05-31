package com.example.webdevhw.services;

import com.example.webdevhw.models.Lesson;
import com.example.webdevhw.models.Widget;
import com.example.webdevhw.repositories.LessonRepository;
import com.example.webdevhw.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class WidgetService {
  @Autowired
  WidgetRepository widgetRepository;
  @Autowired
  LessonRepository lessonRepository;

  @GetMapping("/api/widget")
  public List<Widget> findAllWidgets(){
    return (List<Widget>) widgetRepository.findAll();
  }

  @GetMapping("/api/widget/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
    Optional<Widget> data = widgetRepository.findById(widgetId);
    return data.orElse(null);
  }

  @DeleteMapping("/api/widget/{widgetId}")
  public void deleteWidget(@PathVariable("widgetId") int id) {
    widgetRepository.deleteById(id);
  }

  @PutMapping("/api/widget/{widgetId}")
  public Widget updateWidget(@PathVariable("widgetId") int widgetId, @RequestBody Widget newWidget)
          throws Exception  {
    Optional<Widget> data = widgetRepository.findById(widgetId);
    if (data.isPresent()) {
      Widget course = data.get();
      if (newWidget.getClassName() != null){ course.setClassName(newWidget.getClassName());}
      if (newWidget.getDisplayOrder() != 0){course.setDisplayOrder(newWidget.getDisplayOrder());}
      if (newWidget.getText() != null){course.setText(newWidget.getText());}
      if (newWidget.getWidgetType() != null){ course.setWidgetType(newWidget.getWidgetType());}
      if (newWidget.getWidth() != null){course.setWidth(newWidget.getWidth());}
      if (newWidget.getHeight() != null){course.setHeight(newWidget.getHeight());}
      if (newWidget.getSize() != 0){course.setSize(newWidget.getSize());}
      if (newWidget.getHref() != null){course.setHeight(newWidget.getHref());}
      if (newWidget.getSrc() != null){course.setSrc(newWidget.getSrc());}
      if (newWidget.getListType() != null){course.setListType(newWidget.getListType());}

      widgetRepository.save(course);
      return course;
    }
    else{
      throw new Exception("bad");
    }
  }

  @PutMapping("/api/lesson/{lessonId}/widget")
  public Lesson saveWidget(@PathVariable("lessonId") int lessonId, @RequestBody Lesson newLesson)
          throws Exception  {
    Optional<Lesson> data = lessonRepository.findById(lessonId);
    if (data.isPresent()) {
      Lesson lesson = data.get();
      if (newLesson.getWidget() != null){ lesson.setWidget(newLesson.getWidget());}

      lessonRepository.save(lesson);
      return lesson;
    }
    else{
      throw new Exception("bad");
    }
  }

  @PostMapping("/api/lesson/{lessonId}/widget")
  public Widget createWidget(
          @PathVariable("lessonId") int lessonId,
          @RequestBody Widget newWidget) {
    Optional<Lesson> data = lessonRepository.findById(lessonId);

    if(data.isPresent()) {
      Lesson lesson = data.get();
      newWidget.setLesson(lesson);
      return widgetRepository.save(newWidget);
    }
    return null;
  }

  @GetMapping("/api/lesson/{lessonId}/widget")
  public List<Widget> findAllWidgetsForCourse(
          @PathVariable("lessonId") int lessonId) {
    Optional<Lesson> data = lessonRepository.findById(lessonId);
    if(data.isPresent()) {
      Lesson lesson = data.get();
      return lesson.getWidget();
    }
    return null;
  }



}
