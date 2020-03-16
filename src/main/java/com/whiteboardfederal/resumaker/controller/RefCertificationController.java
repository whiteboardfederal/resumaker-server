package com.whiteboardfederal.resumaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.whiteboardfederal.resumaker.model.RefCertification;
import com.whiteboardfederal.resumaker.repository.RefCertificationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/RefCertification")
class RefCertificationController {

  @Autowired
  private RefCertificationRepository RefCertificationRepository;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<RefCertification> findAll() {
    return RefCertificationRepository.findAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  RefCertification create(@RequestBody RefCertification ref_cert) {
    return RefCertificationRepository.save(ref_cert);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  RefCertification overwrite(@RequestBody RefCertification ref_cert, @PathVariable long id) {
    ref_cert.setId(id);
    return RefCertificationRepository.save(ref_cert);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    RefCertificationRepository.deleteById(id);
  }
}