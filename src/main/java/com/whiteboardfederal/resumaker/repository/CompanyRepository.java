package com.whiteboardfederal.resumaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteboardfederal.resumaker.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}