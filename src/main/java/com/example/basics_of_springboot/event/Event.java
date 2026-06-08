package com.example.basics_of_springboot.event;
//Your Task — Build A Proper Layered Structure
//Create a simple Event API with proper layers:
//        1. Create Event class — just a plain Java class with fields:
//
//id (Long)
//name (String)
//venue (String)
//availableSeats (int)
//Constructor, getters
//
//2. Create EventService class — annotated with @Service:
//
//Store a hardcoded List<Event> in memory (no database yet)
//Method getAllEvents() — returns the list
//Method getEventById(Long id) — returns single event
//
//3. Create EventController class — annotated with @RestController:
//
//Inject EventService via constructor
//@GetMapping("/events") — returns all events
//@GetMapping("/events/{id}") — returns single event, use @PathVariable Long id
//
//Test both endpoints in your request.http file.
//One thing to figure out yourself — how does @PathVariable work? You've seen @GetMapping("/events/{id}"). What goes in the method signature to capture that {id}?
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="name is required")
    private String name;

    @NotBlank(message="venue is required")
    private String venue;

    @Min(value=1,message="avaialabe seats should be atleast 1")
    private int availableSeats;

    public Event() {
    }

    public Event(Long id, String name, String venue, int availableSeats) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.availableSeats = availableSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
