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

import com.whiteboardfederal.resumaker.model.Employee;
import com.whiteboardfederal.resumaker.repository.EmployeeRepository;
import com.whiteboardfederal.resumaker.utils.EntityMissingException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/employee")
class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Employee> query(@RequestParam(required = false, defaultValue = "false") final Boolean includeChildren,
            @RequestParam final Map<String, String> allParams) {
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Employee get(@PathVariable final long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EntityMissingException("employee", id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Employee create(@RequestBody final Employee p, @RequestHeader final Map<String, String> headers) {
        return employeeRepository.save(p);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Employee overwrite(@RequestBody final Employee p, @PathVariable final long id) {
        p.setId(id);
        return employeeRepository.save(p);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void delete(@PathVariable final long id) {
        employeeRepository.deleteById(id);
    }
}