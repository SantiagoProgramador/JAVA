package com.Events.Events.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Events.Events.Entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    public List<Event> findByNameContaining(String name);
}
