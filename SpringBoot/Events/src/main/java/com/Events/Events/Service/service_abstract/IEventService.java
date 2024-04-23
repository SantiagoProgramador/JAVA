package com.riwi.Events.Service.service_abstract;

import java.util.List;
import com.Events.Events.Entity.Event;

public interface IEventService {

    public Event saveEvent(Event event);

    public List<Event> getEvents();

    public Event findEventById(Long id);

    public boolean deleteEvent(Long id);

    public Event updateEvent(Long id, Event event);

    public List<Event> findEvents(String name);

}
