package com.whiteboardfederal.resumaker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "This is an work history entity")
public class WorkHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(notes = "The database generated work history ID")
  private Long id;

  @NotNull(message = "Must be associated with an person")
  @ApiModelProperty(notes = "The database generated person ID")
  private Long personId;

  @NotNull(message = "Name of the Employer")
  @Size(min = 1)
  @ApiModelProperty(notes = "Name of the employer")
  private String employerName;

  @Size(min = 1, max = 30)
  @ApiModelProperty(notes = "The persons work title")
  private String workTitle;

  @Past
  @ApiModelProperty(notes = "The work history start date")
  private Date startDate;

  @PastOrPresent
  @ApiModelProperty(notes = "The work history stop date")
  private Date stopDate;

  public WorkHistory() {
  }

  public WorkHistory(Long personId, String employerName, String workTitle, Date startDate, Date stopDate) {
    this.personId = personId;
    this.employerName = employerName;
    this.workTitle = workTitle;
    this.startDate = startDate;
    this.stopDate = stopDate;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long Id) {
    this.id = id;
  }

  public Long getPersonId() {
    return this.personId;
  }

  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  public String getEmployerName() {
    return this.employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public String getWorkTitle() {
    return this.workTitle;
  }

  public void setWorkTitle(String workTitle) {
    this.workTitle = workTitle;
  }

  public Date getStartDate() {
    return this.startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getStopDate() {
    return this.stopDate;
  }

  public void setStopDate(Date stopDate) {
    this.stopDate = stopDate;
  }

}