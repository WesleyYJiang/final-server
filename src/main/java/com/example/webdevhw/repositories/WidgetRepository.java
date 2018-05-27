package com.example.webdevhw.repositories;

import com.example.webdevhw.models.Widget;

import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository extends CrudRepository<Widget, Integer>{
}
