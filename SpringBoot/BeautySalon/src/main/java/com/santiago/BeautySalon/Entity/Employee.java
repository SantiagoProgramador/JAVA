package com.santiago.BeautySalon.Entity;

import java.util.List;

import com.santiago.BeautySalon.utils.EmployeeRol;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 80, nullable = false)
  private String firstName;

  @Column(length = 80, nullable = false)
  private String lastName;

  @Column(length = 80)
  private String email;

  @Column(length = 20, nullable = false)
  private String phone;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private EmployeeRol employeRol;

  @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private List<Appointment> appointments;
}
