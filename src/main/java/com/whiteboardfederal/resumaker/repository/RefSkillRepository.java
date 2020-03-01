package com.whiteboardfederal.resumaker.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.whiteboardfederal.resumaker.model.RefSkill;

@Repository
public interface RefSkillRepository extends JpaRepository<RefSkill, Long> {
}