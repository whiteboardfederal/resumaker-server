package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.model.Skills;
import com.whiteboardfederal.resumaker.repository.SkillsRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/Skills")
class SkillsController {

  @Autowired
  private SkillsRepository skillsRepository;

  @ApiOperation(value = "Allows you to find all skills available.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Skills> findAll() {
    return skillsRepository.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  Skills get(@PathVariable final long id) throws EntityNotFoundException {
    return skillsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Skills", String.valueOf(id)));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Skills create(@RequestBody Skills newSkill) {
    return skillsRepository.save(newSkill);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Skills overwrite(@RequestBody Skills skill, @PathVariable long id) {
      skill.setId(id);
      return skillsRepository.save(skill);
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    skillsRepository.deleteById(id);
  }
}