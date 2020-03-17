package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.RefCertification;
import com.whiteboardfederal.resumaker.repository.RefCertificationRepository;
import com.whiteboardfederal.resumaker.utils.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiConstants.API_V1 + "/RefCertification")
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