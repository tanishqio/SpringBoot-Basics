package com.example.basics_of_springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Event e= eventservice.getEventByID(id);
        if(e==null){
            //resource sont exist
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.status(200).body(e);
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        Event created= eventservice.CreateEvent(event);
    return ResponseEntity.status(201).body(created);
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Event> DeleteById(@PathVariable Long id){
        Event deleted=eventservice.DeleteById(id);
        if(deleted==null){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateFields(@PathVariable Long id,@RequestBody Event event){
        Event e=eventservice.getEventByID(id);
        if(e==null){
            //resource sont exist
            return ResponseEntity.status(404).body(null);
        }
         Event updated=eventservice.PutEvent(e,event);
        return ResponseEntity.status(200).body(updated);
    }

}

