package com.riwi.Products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Products.Entity.Product;
import com.riwi.Products.Repository.ProductRepositoy;
import com.riwi.Products.Service.service_abstract.IProdcutService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventService {
    @Autowired
    private final EventRepository EventRepository;

    @Override
    public Event saveEvent(Event event) {
        return this.EventRepository.save(product);

    }

    @Override
    public List<Event> getEvents() {
        return this.EventRepository.findAll();
    }

    @Override
    public Event findEventById(Long id) {
        return this.EventRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteEvent(Long id) {
        if (findEventById(id) == null) {
            return false;
        } else
            this.EventRepository.deleteById(id);
        return true;
    }

    @Override
    public Event updateEvent(Long id, Event event) {
        Event eventUpdate = findEventById(id);
        if (eventUpdate == null) {
            return null;
        }
        eventUpdate = event;
        eventUpdate.setId(id);
        return this.EventRepositoy.save(eventUpdate);
    }

    @Override
    public List<Event> findEvents(String name) {
        return null;

    }

}
