package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "ref_skills")
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

  //One to Many Relations
  @OneToMany(mappedBy = "refSkill")
  Set<Skills> skills;

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

  public Set<Skills> getSkills() { return skills;  }

  public void setSkills(Set<Skills> skills) { this.skills = skills; }

}