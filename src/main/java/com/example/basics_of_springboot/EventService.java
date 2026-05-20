package com.example.basics_of_springboot;
//2. Create EventService class — annotated with @Service:
//
//Store a hardcoded List<Event> in memory (no database yet)
//Method getAllEvents() — returns the list
//Method getEventById(Long id) — returns single event
//

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class EventService {
    private List<Event> events=new ArrayList<>(List.of( new Event(1L, "Coldplay Concert", "Delhi", 500),
            new Event(2L, "Tech Summit", "Bangalore", 200),
            new Event(3L, "Comedy Night", "Mumbai", 150)));
    public List<Event> getAllEvents(){
        return events;
    }
    public Event getEventByID(Long id){
        Event ev= events.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    return ev;
    }

    public Event CreateEvent(Event event){
        events.add(event);
        return event;
    }

    public Event DeleteById(Long id){
         Event del=events.stream().filter(x->x.getId().equals(id)).
                 findFirst().orElse(null);
         events.remove(del);
         return del;
    }

    public Event PutEvent(Event old,Event n){
         String name=n.getName();
         String venue=n.getVenue();
        int  availableSeats=n.getAvailableSeats();

        old.setName(name);
        old.setAvailableSeats(availableSeats);
        old.setVenue(venue);

        return old;


    }
}
