package com.example.basics_of_springboot.event;
//2. Create EventService class — annotated with @Service:
//
//Store a hardcoded List<Event> in memory (no database yet)
//Method getAllEvents() — returns the list
//Method getEventById(Long id) — returns single event
//

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }
    // rewrite all methods using repository
    // getAllEvents() → findAll()
    // getEventById() → findById()
    // createEvent() → save()
    // deleteById() → deleteById() + existsById()
    // updateEvent() — find first, update fields, save
    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }
    public Optional<Event> getEventById(Long id){
        return eventRepository.findById(id);
    }
    public Event createEvent(Event e){
        return eventRepository.save(e);
    }
    public boolean deleteById(Long id){
        boolean present=eventRepository.existsById(id);
        if(!present){
            return false;
        }
        eventRepository.deleteById(id);
        return true;
    }
    public Event updateEvent(Event existed,Event updated){
        String name=updated.getName();
        String venue= updated.getVenue();
        int availableSeats= updated.getAvailableSeats();

        existed.setVenue(venue);
        existed.setName(name);
        existed.setAvailableSeats(availableSeats);

        return eventRepository.save(existed);
    }

}
