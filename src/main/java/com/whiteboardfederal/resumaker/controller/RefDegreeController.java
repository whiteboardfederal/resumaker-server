package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.RefDegree;
import com.whiteboardfederal.resumaker.repository.RefDegreeRepository;
import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/RefDegree")
class RefDegreeController {

  @Autowired
  private RefDegreeRepository RefDegreeRepository;

  @ApiOperation(value = "Allows you to find all the degrees provided.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved degrees."),
      @ApiResponse(code = 401, message = "You are not authorized to view degrees"),
      @ApiResponse(code = 403, message = "Accessing these degrees is forbidden"),
      @ApiResponse(code = 404, message = "The degrees you were trying to reach are not found") })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<RefDegree> query() {
    return RefDegreeRepository.findAll();
  }

  @ApiOperation(value = "Allows you to find the degree provided by suppied ID.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved degree."),
      @ApiResponse(code = 401, message = "You are not authorized to view this degree"),
      @ApiResponse(code = 403, message = "Accessing this degree is forbidden"),
      @ApiResponse(code = 404, message = "The degree you were trying to reach is not found") })
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  RefDegree get(@PathVariable final long id) throws EntityNotFoundException {
    return RefDegreeRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("RefDegree", String.valueOf(id)));
  }

  @ApiOperation(value = "Allows you to create a degree.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created degree."),
      @ApiResponse(code = 401, message = "You are not authorized to create degree"),
      @ApiResponse(code = 403, message = "Creating this degree is forbidden") })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  RefDegree create(@RequestBody RefDegree p) {
    return RefDegreeRepository.save(p);
  }

  @ApiOperation(value = "Allows you to update an degree with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the degree with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to update degree"),
      @ApiResponse(code = 403, message = "Updating this degree is forbidden"),
      @ApiResponse(code = 404, message = "The degree you were trying to reach is not found") })
  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  RefDegree overwrite(@RequestBody RefDegree updateDegree, @PathVariable long id) {
    updateDegree.setId(id);
    return RefDegreeRepository.save(updateDegree);
  }

  @ApiOperation(value = "Allows you to delete an degree with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted the degree with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to delete degree"),
      @ApiResponse(code = 403, message = "Deleting this degree is forbidden"),
      @ApiResponse(code = 404, message = "The degree you were trying to reach is not found") })
  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    RefDegreeRepository.deleteById(id);
  }
}