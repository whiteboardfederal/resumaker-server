package com.whiteboardfederal.resumaker.entities.work_history.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Work History of an Employee")
public class WorkHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(notes = "The database generated work history ID")
  private Long id;

  @NotNull(message = "Must be associated with an employee")
  @ApiModelProperty(notes = "Id of employee")
  private Long employeeId;

  @NotNull(message = "Name of the Employer")
  @Size(min = 1)
  private String employerName;

  @Size(min = 1, max = 30)
  private String workTitle;

  @Past
  private Date startDate;

  @PastOrPresent
  private Date stopDate;

  public WorkHistory() {
  }

  public WorkHistory(Long employeeId, String employerName, String workTitle, Date startDate, Date stopDate) {
    this.employeeId = employeeId;
    this.employerName = employerName;
    this.workTitle = workTitle;
    this.startDate = startDate;
    this.stopDate = stopDate;
  }

  public Long getId(){
    return this.id;
  }

  public void setId(Long Id){
    this.id = id;
  }

  public Long getEmployeeId(){
    return this.employeeId;
  }

  public void setEmployeeId(Long employeeId){
    this.employeeId = employeeId;
  }

  public String getEmployerName(){
    return this.employerName;
  }

  public void setEmployerName(String employerName){
    this.employerName = employerName;
  }

  public String getWorkTitle(){
    return this.workTitle;
  }

  public void setWorkTitle(String workTitle){
    this.workTitle = workTitle;
  }

  public Date getStartDate(){
    return this.startDate;
  }

  public void setStartDate(Date startDate){
    this.startDate = startDate;
  }

  public Date getStopDate(){
    return this.stopDate;
  }

  public void setStopDate(Date stopDate){
    this.stopDate = stopDate;
  }

}