package com.example.webdevhw.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Lesson {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  private String title;
  @ManyToOne
  @JsonIgnore
  private Action action;
  @OneToMany(mappedBy="lesson")
  @JsonIgnore
  private List<Widget> Widget;

  public List<Widget> getWidget() {
    return Widget;
  }

  public void setWidget(List<Widget> widget) {
    Widget = widget;
  }
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
  public Action getAction() {
    return action;
  }
  public void setAction(Action action) {
    this.action = action;
  }
}
