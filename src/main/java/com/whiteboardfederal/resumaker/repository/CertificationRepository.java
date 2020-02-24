package com.whiteboardfederal.resumaker.repository;

import com.whiteboardfederal.resumaker.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
