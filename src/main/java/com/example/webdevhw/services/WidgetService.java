package com.example.webdevhw.services;

import com.example.webdevhw.models.Widget;
import com.example.webdevhw.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wesleyjiang on 5/27/18.
 */
@RestController
public class WidgetService {
  @Autowired
  WidgetRepository repository;
  public List<Widget> findAllWidgets(){
    return (List<Widget>) repository.findAll();
  }
}
