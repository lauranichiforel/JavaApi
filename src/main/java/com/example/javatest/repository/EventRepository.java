package com.example.javatest.repository;

import com.example.javatest.api.model.Event;
import com.example.javatest.interfaces.IEventRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public Event update(Long id, Event updatedEvent) {
        Optional<Event> existingEvent = Optional.ofNullable(findById(id));
        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setStartTime(updatedEvent.getStartTime());
            event.setEndTime(updatedEvent.getEndTime());
            event.setAttendees(updatedEvent.getAttendees());
            return event;
        }
        return null;
    }

    @Override
    public List<Event> findByTitle(String title) {
        return events.stream()
                .filter(event -> event.getTitle() != null && event.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findByStartTime(LocalDateTime startTime) {
        return events.stream()
                .filter(event -> event.getStartTime() != null && event.getStartTime().isEqual(startTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findAll() {
        return new ArrayList<>(events);
    }
}