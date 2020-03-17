package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "skills")
public class Skills extends BaseEntity{

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;

  @ManyToOne
  @JoinColumn(name = "ref_skill_id")
  private RefSkill refSkill;

  @NotNull(message = "Must associate number of years of experience.")
  @Column(name = "years_of_experience")
  private double yearsOfExperience;

  public Skills() {
  }

  public Skills(
          Person person,
          RefSkill refSkill,
          double yearsOfExperience
  ) {
    this.person = person;
    this.refSkill = refSkill;
    this.yearsOfExperience = yearsOfExperience;
  }

  public Person getPerson() {
    return this.person;
  }

  public void setPerson(Person personId) {
    this.person = person;
  }

  public RefSkill getSkill() {
    return this.refSkill;
  }

  public void setSkill(RefSkill refSkill) {
    this.refSkill = refSkill;
  }

  public double getYears() {
    return this.yearsOfExperience;
  }

  public void setYears(double yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

}