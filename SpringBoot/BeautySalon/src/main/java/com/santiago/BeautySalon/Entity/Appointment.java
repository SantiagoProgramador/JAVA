package com.santiago.BeautySalon.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "appointments")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime dateTime;

  @Column(nullable = false)
  private int duration;

  @Lob
  private String comments;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id", referencedColumnName = "id")
  private Employee employee;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "service_id", referencedColumnName = "id")
  private Eservice eservice;
}
