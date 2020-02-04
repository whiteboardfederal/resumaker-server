package com.whiteboardfederal.resumaker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "firstName cannot be null")
  @Size(min = 2, max = 30)
  private String firstName;

  @NotNull(message = "Middle initial cannot be null")
  @Size(min = 1, max = 1)
  private String middleInitial;

  @NotNull(message = "lastName cannot be null")
  @Size(min = 2, max = 30)
  private String lastName;

  @Pattern(regexp = "(^$|[0-9]{10})")
  private String cellPhoneNumber;

  @Pattern(regexp = "(^$|[0-9]{10})")
  private String workPhoneNumber;

  @Size(min = 1, max = 30)
  private String workTitle;

  @Size(min = 1, max = 30)
  private String address;

  @NotNull(message = "email cannot be null")
  @Email
  private String email;

  @PastOrPresent
  private Date creationDate = new Date();

  public Employee() {
  }

  public Employee(String firstName, String middleInitial, String lastName,  String cellPhoneNumber,
      String workPhoneNumber, String workTitle, String address, String email, Date creationDate) {
    this.firstName = firstName;
    this.middleInitial = middleInitial;
    this.lastName = lastName;
    this.cellPhoneNumber = cellPhoneNumber;
    this.workPhoneNumber = workPhoneNumber;
    this.workTitle = workTitle;
    this.address = address;
    this.email = email;
    this.creationDate = creationDate;
  }

  /* Id */
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /* First Name */
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /* Middle Initial */
  public String getMiddleInitial() {
    return middleInitial;
  }

  public void setMiddleInitial(String middleInitial) {
    this.middleInitial = middleInitial;
  }

  /* Last Name */
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /* Cell Phone Number */
  public String getCellPhoneNumber() {
    return cellPhoneNumber;
  }

  public void setCellPhoneNumber(String cellPhoneNumber) {
    this.cellPhoneNumber = cellPhoneNumber;
  }

  /* Work Phone Number */
  public String getWorkPhoneNumber() {
    return workPhoneNumber;
  }

  public void setWorkPhoneNumber(String workPhoneNumber) {
    this.workPhoneNumber = workPhoneNumber;
  }

  /* Work Title */
  public String getWorkTitle() {
    return workTitle;
  }

  public void setWorkTitle(String workTitle) {
    this.workTitle = workTitle;
  }

  /* Address */
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  /* Email */
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  /* Creation Date */
  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}