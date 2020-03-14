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

  @ApiOperation(value = "Allows you to find all the work history entities provided.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved work history entities."),
      @ApiResponse(code = 401, message = "You are not authorized to view work history entities"),
      @ApiResponse(code = 403, message = "Accessing this work history entities is forbidden"),
      @ApiResponse(code = 404, message = "The work history entities you were trying to reach are not found") })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<WorkHistory> findAll() {
    return workHistoryRepository.findAll();
  }

  @ApiOperation(value = "Allows you to find the work history entity provided by suppied ID.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved work history entity."),
      @ApiResponse(code = 401, message = "You are not authorized to view work history entity"),
      @ApiResponse(code = 403, message = "Accessing this work history entity is forbidden"),
      @ApiResponse(code = 404, message = "The work history entity you were trying to reach is not found") })
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  WorkHistory get(@PathVariable final long id) throws EntityNotFoundException {
    return workHistoryRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Work History", String.valueOf(id)));
  }

  @ApiOperation(value = "Allows you to create a work history entity.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created work history entity."),
      @ApiResponse(code = 401, message = "You are not authorized to create work history entity"),
      @ApiResponse(code = 403, message = "Creating this work history entity is forbidden") })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  WorkHistory create(@RequestBody WorkHistory newWorkHistory) {
    return workHistoryRepository.save(newWorkHistory);
  }

  @ApiOperation(value = "Allows you to update an work history entity with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the work history entity with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to update work history entity"),
      @ApiResponse(code = 403, message = "Updating this work history entity is forbidden"),
      @ApiResponse(code = 404, message = "The work history entity you were trying to reach is not found") })
  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  WorkHistory overwrite(@RequestBody WorkHistory workHistory, @PathVariable long id) {
    workHistory.setId(id);
    return workHistoryRepository.save(workHistory);
  }

  @ApiOperation(value = "Allows you to delete an work history entity with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted the work history entity with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to delete work history entity"),
      @ApiResponse(code = 403, message = "Deleting this work history entity is forbidden"),
      @ApiResponse(code = 404, message = "The work history entity you were trying to reach is not found") })
  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    workHistoryRepository.deleteById(id);
  }
}