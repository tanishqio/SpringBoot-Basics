package com.example.basics_of_springboot.event;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {
    private final EventService eventservice;

    public EventController(EventService eventservice) {
        this.eventservice=eventservice;
    }

    @GetMapping("/events")
    public List<Event> getAllEvents(){
        return eventservice.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> geteventbyid(@PathVariable Long id){
        Optional<Event> e= eventservice.getEventById(id);
        if(e.isEmpty()){
            //resource sont exist
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(e.get());
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event){
        Event created= eventservice.createEvent(event);
    return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> DeleteById(@PathVariable Long id){
        boolean deleted=eventservice.deleteById(id);
        if(!deleted){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateFields(@PathVariable Long id,@RequestBody Event event){
        Optional<Event> e= eventservice.getEventById(id);
        if(e.isEmpty()){
            //resource sont exist
            return ResponseEntity.status(404).body(null);
        }
         Event updated=eventservice.updateEvent(e.get(),event);
        return ResponseEntity.status(200).body(updated);
    }

}

