package com.example.javatest.repository;

import com.example.javatest.api.model.Event;
import com.example.javatest.interfaces.IEventRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventRepository implements IEventRepository {

    private final List<Event> events = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Event save(Event event) {
        event.setId(nextId++);
        events.add(event);
        return event;
    }

    @Override
    public Event findById(Long id) {
        return events.stream()
                .filter(event -> event.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        events.removeIf(event -> event.getId().equals(id));
    }
}
