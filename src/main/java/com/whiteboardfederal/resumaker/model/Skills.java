package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Skills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;

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
          Person person,
//          RefSkill refSkill,
          double yearsOfExperience
  ) {
    this.person = person;
//    this.refSkill = refSkill;
    this.yearsOfExperience = yearsOfExperience;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Person getPerson() {
    return this.person;
  }

  public void setPerson(Person personId) {
    this.person = person;
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