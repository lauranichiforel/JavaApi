package com.example.javatest.api.model;


import lombok.Data;

@Data
public class Attendee {
    private Long id;

    private String name;

    private String email;

    private Boolean attending;

    public Attendee(final Long id, final String name, final String email, final Boolean attending){
        this.id = id;
        this.name = name;
        this.email = email;
        this.attending = attending;
    }
}


