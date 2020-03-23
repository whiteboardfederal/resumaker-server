package com.whiteboardfederal.resumaker.repository;

import com.whiteboardfederal.resumaker.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
