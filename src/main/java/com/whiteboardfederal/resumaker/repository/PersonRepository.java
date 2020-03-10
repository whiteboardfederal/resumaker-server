package com.whiteboardfederal.resumaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whiteboardfederal.resumaker.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}