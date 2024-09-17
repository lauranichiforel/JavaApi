package org.example.javatest;

import com.example.javatest.api.model.Event;
import com.example.javatest.repository.EventRepository;
import com.example.javatest.service.EventService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    public EventServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateEvent() {
        // Arrange
        Event event = new Event(1L, "Title", "Description", LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        when(eventRepository.save(event)).thenReturn(event);

        // Act
        Event createdEvent = eventService.createEvent(event);

        // Assert
        verify(eventRepository, times(1)).save(event);
        assertNotNull(createdEvent);
    }

    @Test
    public void testDeleteEvent() {
        // Arrange
        Long eventId = 1L;

        // Act
        eventService.deleteEvent(eventId);

        // Assert
        verify(eventRepository, times(1)).deleteById(eventId);
    }

    @Test
    public void testUpdateEvent() {
        // Arrange
        Event event = new Event(1L, "Title", "Description", LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        when(eventRepository.findById(1L)).thenReturn(event);
        when(eventRepository.update(anyLong(), any(Event.class))).thenReturn(event);

        // Act
        event.setTitle("Updated Title");
        Event updatedEvent = eventService.updateEvent(1L, event);

        // Assert
        verify(eventRepository, times(1)).update(anyLong(), any(Event.class));
        assertEquals("Updated Title", updatedEvent.getTitle());
    }
}