package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class RefBaseEntity extends BaseEntity {
  
  @NotNull(message = "Must be associated with an employee")
  @Column(name="value")
  private String value;

  @Size(min = 2, max = 100)
  @Column(name="description")
  private String description;

  public RefBaseEntity() {
  }

  public RefBaseEntity(String value, String description) {
    this.value = value;
    this.description = description;
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

}