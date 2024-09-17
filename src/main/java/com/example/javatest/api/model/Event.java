package com.example.javatest.api.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Event {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private List<Attendee> attendees;

    public Event(final Long id, final String title, final String description, final LocalDateTime startTime, final LocalDateTime endTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter și Setter pentru title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter și Setter pentru description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter și Setter pentru startTime
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    // Getter și Setter pentru endTime
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // Getter și Setter pentru attendees
    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<Attendee> attendees) {
        this.attendees = attendees;
    }
}
