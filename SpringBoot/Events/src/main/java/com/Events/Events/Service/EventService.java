package com.Events.Events.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Events.Events.Entity.Event;
import com.Events.Events.Repository.EventRepository;
import com.Events.Events.Service.service_abstract.IEventService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
    @Autowired
    private final EventRepository EventRepository;

    @Override
    public Event saveEvent(Event event) {
        return this.EventRepository.save(event);

    }

    // @Override
    // public List<Event> getEvents() {
    // return this.EventRepository.findAll();
    // }

    @Override
    public Event findEventById(String id) {
        return this.EventRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteEvent(String id) {
        if (findEventById(id) == null) {
            return false;
        } else
            this.EventRepository.deleteById(id);
        return true;
    }

    @Override
    public Event updateEvent(String id, Event event) {
        Event eventUpdate = findEventById(id);
        if (eventUpdate == null) {
            return null;
        }
        eventUpdate = event;
        eventUpdate.setId(id);
        return this.EventRepository.save(eventUpdate);
    }

    @Override
    public List<Event> findEvents(String name) {
        return this.EventRepository.findByNameContaining(name);

    }

    public Page<Event> findPaginated(int page, int size) {
        if (page < 0) {
            page = 1;
        }

        Pageable pageable = PageRequest.of(page, size);

        return this.EventRepository.findAll(pageable);
    }

}
