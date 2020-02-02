package com.whiteboardfederal.resumaker.entities.work_history.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.whiteboardfederal.resumaker.entities.work_history.model.WorkHistory;

public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

  // Find all work history with a certain employee id
  public List<WorkHistory> findByEmployeeId(Long employeeId);

}