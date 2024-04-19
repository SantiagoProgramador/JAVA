package com.dailyTasks.dailyTasks.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "Task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "title", length = 100, nullable = false)
  private String title;

  @Column(name = "description", length = 255, nullable = true)
  private String description;

  @Column(name = "creationDate", nullable = false)
  private LocalDate creationDate;

  @Column(name = "creationTime", nullable = false)
  private LocalTime creationTime;

  @Column(name = "status", length = 50, nullable = false)
  private Status status;

  public Task(Long id, String title, String description, LocalDate creationDate, LocalTime creationTime,
      Status status) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.creationDate = creationDate;
    this.creationTime = creationTime;
    this.status = status;
  }

  public Task() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public LocalTime getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(LocalTime creationTime) {
    this.creationTime = creationTime;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Task [id=" + id + ", title=" + title + ", description=" + description + ", creationDate=" + creationDate
        + ", creationTime=" + creationTime + ", status=" + status + "]";
  }
}
