package com.riwi.Events.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Events.Events.Entity.Event;

@Repository
public interface EventRepositoy extends JpaRepository<Event, Long> {
    public Product findByNameContaining(String name);
}
