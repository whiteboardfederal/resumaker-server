package com.whiteboardfederal.resumaker.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.model.WorkHistory;
import com.whiteboardfederal.resumaker.repository.WorkHistoryRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/workHistory")
class WorkHistoryController {

    @Autowired
  private WorkHistoryRepository workHistoryRepository;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<WorkHistory> findAll() {
    return workHistoryRepository.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  WorkHistory get(@PathVariable final long id) throws EntityNotFoundException {
    return workHistoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Work History", String.valueOf(id)));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  WorkHistory create(@RequestBody WorkHistory newWorkHistory) {
    return workHistoryRepository.save(newWorkHistory);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  WorkHistory overwrite(@RequestBody WorkHistory workHistory, @PathVariable long id) {
      workHistory.setId(id);
      return workHistoryRepository.save(workHistory);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    workHistoryRepository.deleteById(id);
  }
}