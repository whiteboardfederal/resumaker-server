package com.whiteboardfederal.resumaker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RefSkill {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "Name of the RefSkill")
  @Size(min = 1)
  private String name;

  @NotNull(message = "Description of RefSkill")
  @Size(min = 1)
  private String desc;

  public RefSkill() {
  }

  public RefSkill(String name, String desc) {
   this.name = name;
   this.desc = desc;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long Id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return this.desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

}