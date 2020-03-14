package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.Skills;
import com.whiteboardfederal.resumaker.repository.SkillsRepository;

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
@RequestMapping(value = "/api/v1/Skills")
class SkillsController {

  @Autowired
  private SkillsRepository skillsRepository;

  @ApiOperation(value = "Allows you to find all the skills provided.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved skills."),
      @ApiResponse(code = 401, message = "You are not authorized to view skills"),
      @ApiResponse(code = 403, message = "Accessing this skills is forbidden"),
      @ApiResponse(code = 404, message = "The skills you were trying to reach are not found") })
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Skills> findAll() {
    return skillsRepository.findAll();
  }

  @ApiOperation(value = "Allows you to find the skill provided by suppied ID.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved skill."),
      @ApiResponse(code = 401, message = "You are not authorized to view skill"),
      @ApiResponse(code = 403, message = "Accessing this skill is forbidden"),
      @ApiResponse(code = 404, message = "The skill you were trying to reach is not found") })
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  Skills get(@PathVariable final long id) throws EntityNotFoundException {
    return skillsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skills", String.valueOf(id)));
  }

  @ApiOperation(value = "Allows you to create a skill.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created skill."),
      @ApiResponse(code = 401, message = "You are not authorized to create skill"),
      @ApiResponse(code = 403, message = "Creating this skill is forbidden") })
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Skills create(@RequestBody Skills newSkill) {
    return skillsRepository.save(newSkill);
  }

  @ApiOperation(value = "Allows you to update an skill with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the skill with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to update skill"),
      @ApiResponse(code = 403, message = "Updating this skill is forbidden"),
      @ApiResponse(code = 404, message = "The skill you were trying to reach is not found") })
  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Skills overwrite(@RequestBody Skills skill, @PathVariable long id) {
    skill.setId(id);
    return skillsRepository.save(skill);
  }

  @ApiOperation(value = "Allows you to delete an skill with provided id.")
  @ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted the skill with provided id."),
      @ApiResponse(code = 401, message = "You are not authorized to delete skill"),
      @ApiResponse(code = 403, message = "Deleting this skill is forbidden"),
      @ApiResponse(code = 404, message = "The skill you were trying to reach is not found") })
  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    skillsRepository.deleteById(id);
  }
}