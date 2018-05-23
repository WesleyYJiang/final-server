package com.example.webdevhw.models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Module {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  @OneToMany(mappedBy="module")
  private List<Lesson> lessons;
  @ManyToOne
  @JsonIgnore
  private Course course;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Course getCourse() {
    return course;
  }
  public void setCourse(Course course) {
    this.course = course;
  }
  public List<Lesson> getLessons() {
    return lessons;
  }
}