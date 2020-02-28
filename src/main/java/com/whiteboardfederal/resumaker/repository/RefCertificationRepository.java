package com.whiteboardfederal.resumaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.whiteboardfederal.resumaker.model.RefCertification;
import org.springframework.stereotype.Repository;

@Repository
public interface RefCertificationRepository extends JpaRepository<RefCertification, Long> {

}