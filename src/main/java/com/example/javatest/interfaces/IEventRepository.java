package com.example.javatest.interfaces;

import com.example.javatest.api.model.Event;

public interface IEventRepository {
    Event save(Event event);
    Event findById(Long id);
    void deleteById(Long id);
}
