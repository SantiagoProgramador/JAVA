package com.santiago.Vacant.Entity.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Vacant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 200, nullable = false)
  private String description;

  @Column(length = 40, nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(length = 40, nullable = false)
  private String title;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Company company;

}
