package com.whiteboardfederal.resumaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Education for an Person")
public class Education {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(notes = "The database generated education ID")
  private Long id;

  @NotNull(message = "Must be associated with an person")
  @ApiModelProperty(notes = "The personId associated with person")
  private Long personId;

  @Size(min = 2, max = 40)
  @ApiModelProperty(notes = "The school the person attended")
  private String school;

  @Size(min = 2, max = 40)
  @ApiModelProperty(notes = "The degree received from the school the person attended")
  private String degree;

  public Education() {
  }

  public Education(Long personId, String school, String degree) {
    this.personId = personId;
    this.school = school;
    this.degree = degree;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPersonId() {
    return this.personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
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