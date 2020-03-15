package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.model.RefDegree;
import com.whiteboardfederal.resumaker.repository.RefDegreeRepository;
import com.whiteboardfederal.resumaker.utils.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiConstants.API_V1 + "/RefDegree")
class RefDegreeController {

  @Autowired
  private RefDegreeRepository RefDegreeRepository;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<RefDegree> query() {
    return RefDegreeRepository.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  RefDegree get(@PathVariable final long id) throws EntityNotFoundException {
    return RefDegreeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RefDegree", String.valueOf(id)));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  RefDegree create(@RequestBody RefDegree p) {
    return RefDegreeRepository.save(p);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  RefDegree overwrite(@RequestBody RefDegree updateDegree, @PathVariable long id) {
    updateDegree.setId(id);
    return RefDegreeRepository.save(updateDegree);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    RefDegreeRepository.deleteById(id);
  }
}