package com.whiteboardfederal.resumaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteboardfederal.resumaker.model.Education;

public interface EducationRepository extends JpaRepository<Education, Long> {
}