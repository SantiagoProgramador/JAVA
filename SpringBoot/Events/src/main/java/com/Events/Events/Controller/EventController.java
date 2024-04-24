package com.Events.Events.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Events.Events.Entity.Event;
import com.Events.Events.Service.service_abstract.IEventService;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<Event>> ShowEvents(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "1") int size) {

        return ResponseEntity.ok(this.iEventService.findPaginated(page - 1, size));
    }

    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        if (event.getCapacity() < 0 || event.getDate().isBefore(LocalDate.now())) {
            return null;
        }
        return new ResponseEntity<>(this.iEventService.saveEvent(event), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Event> ShowEvent(@PathVariable String id) {
        return ResponseEntity.ok(this.iEventService.findEventById(id));
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Event> eventToUpdate(@PathVariable String id, @RequestBody Event event) {
        if (event.getCapacity() < 0 || event.getDate().isBefore(LocalDate.now())) {
            return null;
        }
        return ResponseEntity.ok(this.iEventService.updateEvent(id, event));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Boolean> eventToDelete(@PathVariable String id) {

        return ResponseEntity.ok(this.iEventService.deleteEvent(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Event>> filterEventsByName(@RequestParam String name) {

        return ResponseEntity.ok(this.iEventService.findEvents(name));
    }

}