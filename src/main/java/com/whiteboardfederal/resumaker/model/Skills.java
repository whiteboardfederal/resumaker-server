package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skills {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

//  @Column(name = "person_id")
//  private Person person;

  @OneToOne
  @JoinColumn(name = "ref_skill_id")
  private RefSkill refSkill;

  @NotNull(message = "Must associate number of years of experience.")
  @JoinColumn(name = "years_of_experience")
  private double yearsOfExperience;

  //Collections
  @ManyToMany(mappedBy = "skills", fetch = FetchType.LAZY)
  private List<Person> persons = new ArrayList<Person>();

  public Skills() {
  }

  public Skills(
          RefSkill refSkill,
          double yearsOfExperience
  ) {
    this.refSkill = refSkill;
    this.yearsOfExperience = yearsOfExperience;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

//  public Person getPerson() {
//    return this.person;
//  }
//
//  public void setPerson(Person personId) {
//    this.person = person;
//  }

  public RefSkill getSkill() { return this.refSkill; }

  public void setSkill(RefSkill refSkill) { this.refSkill = refSkill;  }

  public double getYears() {
    return this.yearsOfExperience;
  }

  public void setYears(double yearsOfExperience) {
    this.yearsOfExperience = yearsOfExperience;
  }

  public List<Person> getPersons() { return this.persons; }

  public void setPersons(List<Person> persons) {this.persons = persons;}

}