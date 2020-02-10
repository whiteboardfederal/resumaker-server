package com.whiteboardfederal.resumaker.model;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.whiteboardfederal.resumaker.model.Employee;

public interface SkillRepository extends JpaRepository<Skill, Long> {

  // Find all employees with a certain last name
  public List<Skill> findByName(String name);

  // Paging
  @Query("SELECT e FROM Employee e ORDER BY e.lastName ASC")
  List<Skill> getSkills(Pageable pageable);

  // Paging
  List<Skill> findAllByOrderByNameAsc(Pageable pageable);
}