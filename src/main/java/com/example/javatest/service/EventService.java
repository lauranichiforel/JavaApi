package com.example.javatest.service;

import com.example.javatest.api.model.Event;
import com.example.javatest.interfaces.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private final IEventRepository eventRepository;

    @Autowired
    public EventService(IEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    private List<Event> events = new ArrayList<>();
    private Long currentEventId = 1L;
    private Long currentAttendeeId = 1L;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
