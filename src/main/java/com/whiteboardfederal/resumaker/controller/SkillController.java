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

import com.whiteboardfederal.resumaker.model.Skill;
import com.whiteboardfederal.resumaker.model.SkillRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/skill")
class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Skill> query(@RequestParam(required = false, defaultValue = "false") Boolean includeChildren,
            @RequestParam Map<String, String> allParams) {
        return skillRepository.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Skill create(@RequestBody Skill p, @RequestHeader Map<String, String> headers) {
        return skillRepository.save(p);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Skill overwrite(@RequestBody Skill p, @PathVariable long id) {
        p.setId(id);
        return skillRepository.save(p);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void delete(@PathVariable long id) {
        skillRepository.deleteById(id);
    }
}