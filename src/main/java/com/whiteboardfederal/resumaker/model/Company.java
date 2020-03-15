package com.whiteboardfederal.resumaker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "A company that a person has or is working for")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated education ID")
	@Column(name="company_id")
	private Long id;

	@Size(min = 2, max = 100)
	@ApiModelProperty(notes = "The name of the company")
	private String name;

//	@OneToMany(mappedBy = "company")
	//private Set<WorkHistory> workHistory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/*
	public Set<WorkHistory> getWorkHistory() {
		return workHistory;
	}

	public void setWorkHistory(Set<WorkHistory> workHistory) {
		this.workHistory = workHistory;
	}
	*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
