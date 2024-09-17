package com.example.javatest.service;

import com.example.javatest.api.model.Event;
import com.example.javatest.interfaces.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final IEventRepository eventRepository;

    @Autowired
    public EventService(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.update(id, updatedEvent);
    }

    public boolean deleteEvent(Long id) {
        eventRepository.deleteById(id);
        return true;
    }

    public List<Event> getFilteredEvents(String title, LocalDateTime startTime) {
        List<Event> filteredEvents = eventRepository.findAll();
        if (title != null && !title.isEmpty()) {
            filteredEvents = eventRepository.findByTitle(title);
        }
        if (startTime != null) {
            filteredEvents = filteredEvents.stream()
                    .filter(event -> event.getStartTime().isEqual(startTime))
                    .collect(Collectors.toList());
        }
        return filteredEvents;
    }
}