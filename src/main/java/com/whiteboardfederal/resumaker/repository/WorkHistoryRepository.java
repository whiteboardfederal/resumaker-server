package com.whiteboardfederal.resumaker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.whiteboardfederal.resumaker.model.WorkHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

  // Find all work history with a certain person id
  public List<WorkHistory> findByPersonId(Long personId);

}