package com.whiteboardfederal.resumaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteboardfederal.resumaker.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}