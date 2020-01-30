package com.whiteboardfederal.resumaker.entities.employee.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.whiteboardfederal.resumaker.entities.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  // Find all employees with a certain last name
  public List<Employee> findByLastName(String lastName);

  // Using the 'LIKE' sql command
  public List<Employee> findByFirstNameContaining(String searchString);

  // Paging
  @Query("SELECT e FROM Employee e ORDER BY e.lastName ASC")
  List<Employee> getEmployees(Pageable pageable);

  // Paging
  List<Employee> findAllByOrderByLastNameAsc(Pageable pageable);

}