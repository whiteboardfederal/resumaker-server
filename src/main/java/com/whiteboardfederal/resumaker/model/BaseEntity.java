package com.whiteboardfederal.resumaker.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  public BaseEntity() {
  }

  public BaseEntity(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long Id) {
    this.id = id;
  }
}