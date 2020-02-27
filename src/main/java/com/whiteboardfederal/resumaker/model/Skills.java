package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Skills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private Employee employee;

//  uncomment once RefSkill is committed.
//  @OneToOne
//  @JoinColumn(name = "ref_skill_id")
//  private RefSkill refSkill;

  @NotNull(message = "Must associate number of years of experience.")
  @JoinColumn(name = "years_of_experience")
  private double yearsOfExperience;

  public Skills() {
  }

  public Skills(
          Employee employee,
//          RefSkill refSkill,
          double yearsOfExperience
  ) {
    this.employee = employee;
//    this.refSkill = refSkill;
    this.yearsOfExperience = yearsOfExperience;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employeeId) {
    this.employee = employee;
  }

//  public Long getSkill() { return this.refSkill; }
//
//  public void setSkill(Long refSkill) { this.refSkill = refSkill;  }

  public double getYears() {
    return this.yearsOfExperience;
  }

  public void setYears(double yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

}