package com.whiteboardfederal.resumaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "Must be associated with an employee")
  private Long employeeId;

  @Size(min = 2, max = 40)
  private String school;

  @Size(min = 2, max = 40)
  private String degree;

  public Education() {
  }

  public Education(Long employeeId, String school, String degree) {
    this.employeeId = employeeId;
    this.school = school;
    this.degree = degree;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getEmployeeId() {
    return this.employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getSchool() {
    return this.school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getDegree() {
    return this.degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

}