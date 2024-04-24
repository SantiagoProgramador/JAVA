package com.Events.Events.Service.service_abstract;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Events.Events.Entity.Event;

public interface IEventService {

    public Event saveEvent(Event event);

    // public List<Event> getEvents();

    public Event findEventById(String id);

    public boolean deleteEvent(String id);

    public Event updateEvent(String id, Event event);

    public List<Event> findEvents(String name);

    public Page<Event> findPaginated(int page, int size);

}
