package com.whiteboardfederal.resumaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Certifications tied to a person")
public class RefCertification {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @ApiModelProperty(notes = "The database generated certification ID")
  private Long id;

  @NotNull(message = "Value of the Certification") //title
  @ApiModelProperty(notes = "Value of the certification")
  private String value;

  @NotNull(message = "Description of the Certification")
  @ApiModelProperty(notes = "Description of the certification")
  private String description;

  @NotNull(message = "How many years the Certifcation is valid")
  @ApiModelProperty(notes = "Number of years the certification is valid for")
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