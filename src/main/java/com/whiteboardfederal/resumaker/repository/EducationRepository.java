package com.whiteboardfederal.resumaker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteboardfederal.resumaker.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
  // Find all employees with a certain last name
  public List<Education> findByEmployeeId(Long employeeId);
}