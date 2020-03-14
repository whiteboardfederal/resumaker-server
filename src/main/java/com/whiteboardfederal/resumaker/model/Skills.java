package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Skills tied to a person")
public class Skills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(notes = "The database generated skills ID")
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  @ApiModelProperty(notes = "The person tied to the skill")
  private Person person;

//  uncomment once RefSkill is committed.
//  @OneToOne
//  @JoinColumn(name = "ref_skill_id")
//  private RefSkill refSkill;

  @NotNull(message = "Must associate number of years of experience.")
  @JoinColumn(name = "years_of_experience")
  @ApiModelProperty(notes = "The number of years for that given skill")
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