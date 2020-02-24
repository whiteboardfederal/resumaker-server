package com.whiteboardfederal.resumaker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.whiteboardfederal.resumaker.model.WorkHistory;

public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

  // Find all work history with a certain employee id
  public List<WorkHistory> findByEmployeeId(Long employeeId);

}