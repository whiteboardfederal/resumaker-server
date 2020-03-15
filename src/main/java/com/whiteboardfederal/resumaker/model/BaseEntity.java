package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  public BaseEntity() {
  }

//  public BaseEntity(Long id) {
//    this.id = id;
//  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long Id) {
    this.id = id;
  }
}