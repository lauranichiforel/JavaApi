package com.example.javatest.interfaces;

import com.example.javatest.api.model.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface IEventRepository {
    Event save(Event event);
    Event findById(Long id);
    void deleteById(Long id);
    Event update(Long id, Event updatedEvent);
    List<Event> findByTitle(String title);
    List<Event> findByStartTime(LocalDateTime startTime);
    List<Event> findAll();
}
