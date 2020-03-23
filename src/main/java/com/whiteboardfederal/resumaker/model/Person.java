package com.whiteboardfederal.resumaker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.Nullable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "This is an employee")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(notes = "The database generated employee ID")
  private Long id;

  @NotNull(message = "firstName cannot be null")
  @Size(min = 2, max = 30)
  @ApiModelProperty(notes = "The first name of the employee")
  private String firstName;

  @Nullable
  @Size(min = 2, max = 30)
  @ApiModelProperty(notes = "The middle name of the employee")
  private String middleName;

  @NotNull(message = "lastName cannot be null")
  @Size(min = 2, max = 30)
  @ApiModelProperty(notes = "The last name of the employee")
  private String lastName;

  @Pattern(regexp = "(^$|[0-9]{10})")
  @ApiModelProperty(notes = "The cell phone number of the employee")
  private String cellPhoneNumber;

  @Pattern(regexp = "(^$|[0-9]{10})")
  @ApiModelProperty(notes = "The work phone number of the employee")
  private String workPhoneNumber;

  @Size(min = 1, max = 30)
  @ApiModelProperty(notes = "The current work title of the employee")
  private String workTitle;

  @Size(min = 1, max = 30)
  @ApiModelProperty(notes = "The current address of the employee")
  private String address;

  @NotNull(message = "email cannot be null")
  @Email
  @ApiModelProperty(notes = "The current email of the employee")
  private String email;

  @PastOrPresent
  @ApiModelProperty(notes = "The date the employee was created in the system")
  private Date creationDate = new Date();

  //One to Many Relations
  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
  private List<Certification> certifications;

  @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Skills> skills = new ArrayList<Skills>();

  public Person() {
  }

  public Person(String firstName, String middleName, String lastName, String cellPhoneNumber,
      String workPhoneNumber, String workTitle, String address, String email, Date creationDate) {
    this.firstName = firstName;
    this.middleName = middleName;
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

  /* Middle Name */
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
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

  public List<Certification> getCertifications() {
    return certifications;
  }

  public void setCertifications(List<Certification> certifications) {
    this.certifications = certifications;
  }
  public List<Skills> getSkills() { return skills; }

  public void setSkills(List<Skills> skills) {this.skills = skills;}
}