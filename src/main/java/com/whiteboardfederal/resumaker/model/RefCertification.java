package com.whiteboardfederal.resumaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

//What are these imports?
/*
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size; //Should I use this for size of description??
*/

@Entity
public class RefCertification {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "Value of the Certification") //title
  private String value;

  @NotNull(message = "Description of the Certification")
  private String description;

  @NotNull(message = "How many years the Certifcation is valid")
  private int yearsValid;

    public RefCertification() {
    }

    public RefCertification(String value, String description, int yearsValid) {
        this.value = value;
        this.description = description;
        this.yearsValid = yearsValid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearsValid() {
        return this.yearsValid;
    }

    public void setYearsValid(int yearsValid) {
        this.yearsValid = yearsValid;
    }

}