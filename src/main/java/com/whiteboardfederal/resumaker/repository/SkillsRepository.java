package com.whiteboardfederal.resumaker.repository;

import com.whiteboardfederal.resumaker.model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
}