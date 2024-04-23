package com.Events.Events.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Events.Events.Entity.Event;
import com.Events.Events.Service.service_abstract.IEventService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/Events")
@AllArgsConstructor
public class EventController {
    @Autowired
    private final IEventService iEventService;

    @GetMapping
    public ResponseEntity<List<Event>> ShowEvents() {

        return ResponseEntity.ok(this.iEventService.getEvents());
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
            if (event.getCapacity() < 0 || event.getDate().before(LocalDate.now)){
                return  null;
            }
        return new ResponseEntity<>(this.iEventService.saveEvent(event), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> ShowEvent(@PathVariable Long id) {
        return ResponseEntity.ok(this.iEventService.findEventById(id));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Event> eventToUpdate(@PathVariable Long id, @RequestBody Event event) {
        if (event.getCapacity() < 0 || event.getDate().before(LocalDate.now)){
            return  null;
        }
        return ResponseEntity.ok(this.iEventService.updateEvent(id, event));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> eventToDelete(@PathVariable Long id) {

        return ResponseEntity.ok(this.iEventService.deleteEvent(id));
    }


}