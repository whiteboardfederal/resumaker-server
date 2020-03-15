package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.model.WorkHistory;
import com.whiteboardfederal.resumaker.repository.WorkHistoryRepository;
import com.whiteboardfederal.resumaker.utils.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiConstants.API_V1 + "/workHistory")
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