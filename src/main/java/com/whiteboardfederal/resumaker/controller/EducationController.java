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

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.model.Education;
import com.whiteboardfederal.resumaker.repository.EducationRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/education")
class EducationController {

  @Autowired
  private EducationRepository educationRepository;

  @ApiOperation(value = "Allows you to find all the education entities.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved all education entities."),
      @ApiResponse(code = 401, message = "You are not authorized to view education entities"),
      @ApiResponse(code = 403, message = "Accessing this education entities are forbidden"),
      @ApiResponse(code = 404, message = "The education entities you were trying to reach are not found") })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Education> query() {
    return educationRepository.findAll();
  }

  @ApiOperation(value = "Allows you to find the education entity provided by suppied ID.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved education entity."),
      @ApiResponse(code = 401, message = "You are not authorized to view education entity"),
      @ApiResponse(code = 403, message = "Accessing this education entity is forbidden"),
      @ApiResponse(code = 404, message = "The education entity you were trying to reach is not found") })
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  Education get(@PathVariable final long id) throws EntityNotFoundException {
    return educationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("education", String.valueOf(id)));
  }

  @ApiOperation(value = "Allows you to create an education entity.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created education entity."),
      @ApiResponse(code = 401, message = "You are not authorized to create education entity"),
      @ApiResponse(code = 403, message = "Creating this education entity is forbidden") })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Education create(@RequestBody Education p) {
    return educationRepository.save(p);
  }

  @ApiOperation(value = "Allows you to update an education entity with provided id.")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully updated the education entity with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to update education entity"),
      @ApiResponse(code = 403, message = "Updating this education entity is forbidden"),
      @ApiResponse(code = 404, message = "The education entity you were trying to reach is not found") })
  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Education overwrite(@RequestBody Education p, @PathVariable long id) {
    p.setId(id);
    return educationRepository.save(p);
  }

  @ApiOperation(value = "Allows you to delete an education entity with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully deleted the education entity with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to delete education entity"),
      @ApiResponse(code = 403, message = "Deleting this education entity is forbidden"),
      @ApiResponse(code = 404, message = "The education entity you were trying to reach is not found") })
  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    educationRepository.deleteById(id);
  }
}