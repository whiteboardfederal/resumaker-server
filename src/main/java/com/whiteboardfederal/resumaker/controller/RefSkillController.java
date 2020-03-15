package com.whiteboardfederal.resumaker.controller;

import com.whiteboardfederal.resumaker.model.RefSkill;
import com.whiteboardfederal.resumaker.repository.RefSkillRepository;
import com.whiteboardfederal.resumaker.utils.ApiConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiConstants.API_V1 + "/RefSkill")
class RefSkillController {

    @Autowired
    private RefSkillRepository refSkillRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<RefSkill> query() {
        return refSkillRepository.findAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RefSkill create(@RequestBody RefSkill skill) {
        return refSkillRepository.save(skill);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RefSkill overwrite(@RequestBody RefSkill skill, @PathVariable long id) {
        skill.setId(id);
        return refSkillRepository.save(skill);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void delete(@PathVariable long id) {
        refSkillRepository.deleteById(id);
    }
}