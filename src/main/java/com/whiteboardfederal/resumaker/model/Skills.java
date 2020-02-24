package com.whiteboardfederal.resumaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Skills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "Must be associated with an employee")
  private Long employeeId;

  @NotNull(message = "Must be associated with a skill")
  private Long refSkill; //Change Type to RefSkill when it's committed.

  @NotNull(message = "Must associate number of years of experience.")
  private double yearsOfExperience;

  public Skills() {
  }

  public Skills(
          Long employeeId,
          Long refSkill,
          double yearsOfExperience
  ) {
    this.employeeId = employeeId;
    this.refSkill = refSkill;
    this.yearsOfExperience = yearsOfExperience;
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

  public Long getSkill() {
    return this.refSkill;
  }

  public void setSkill(Long refSkill) { this.refSkill = refSkill;  }

  public double getYears() {
    return this.yearsOfExperience;
  }

  public void setYears(double yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

}