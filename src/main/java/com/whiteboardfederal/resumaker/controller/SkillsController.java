package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.Skills;
import com.whiteboardfederal.resumaker.repository.SkillsRepository;

import com.whiteboardfederal.resumaker.utils.EntityMissingException;
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
  private SkillsRepository SkillsRepository;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Skills> findAll() {
    return SkillsRepository.findAll();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  Skills get(@PathVariable final long id) {
    return SkillsRepository.findById(id).orElseThrow(() -> new EntityMissingException("Skills", id));
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Skills create(@RequestBody Skills newSkill) {
    return SkillsRepository.save(newSkill);
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Skills overwrite(@RequestBody Skills updateSkill, @PathVariable long id) {
    return SkillsRepository.findById(id).map(skills -> {
      skills.setEmployeeId(updateSkill.getEmployeeId());
      skills.setSkill(updateSkill.getSkill());
      skills.setYears(updateSkill.getYears());
      return SkillsRepository.save(skills);
    }).orElseGet(()->{
      updateSkill.setId(id);
      return SkillsRepository.save(updateSkill);
    });
  }

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  void delete(@PathVariable long id) {
    SkillsRepository.deleteById(id);
  }
}