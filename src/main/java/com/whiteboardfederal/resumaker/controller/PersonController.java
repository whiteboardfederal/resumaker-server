package com.whiteboardfederal.resumaker.controller;

import java.util.List;

import com.whiteboardfederal.resumaker.model.Employee;
import com.whiteboardfederal.resumaker.repository.EmployeeRepository;
import com.whiteboardfederal.resumaker.services.PersonServices;
import com.whiteboardfederal.resumaker.utils.EntityMissingException;

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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/person")
class PersonController extends BaseController {

    
    @Autowired
    private PersonServices personServices;

    @ApiOperation(value = "Allows you to find all the employees provided.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved employees."),
            @ApiResponse(code = 401, message = "You are not authorized to view employees"),
            @ApiResponse(code = 403, message = "Accessing this employees is forbidden"),
            @ApiResponse(code = 404, message = "The employees you were trying to reach are not found") })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Employee> findAll() {
        return personServices.findAll();
    }

    @ApiOperation(value = "Allows you to find the employee provided by suppied ID.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved employee."),
            @ApiResponse(code = 401, message = "You are not authorized to view employee"),
            @ApiResponse(code = 403, message = "Accessing this employee is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found") })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Employee get(@PathVariable final long id) {
    		return personServices.get(id);
    }

    @ApiOperation(value = "Allows you to create an employee.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created employee."),
            @ApiResponse(code = 401, message = "You are not authorized to create employee"),
            @ApiResponse(code = 403, message = "Creating this employee is forbidden") })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Employee create(@RequestBody final Employee person) {
        return personServices.save(person);
    }

    @ApiOperation(value = "Allows you to update an employee with provided id.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the employee with provided id."),
            @ApiResponse(code = 401, message = "You are not authorized to update employee"),
            @ApiResponse(code = 403, message = "Updating this employee is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found") })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void overwrite(@RequestBody final Employee p) {
    		personServices.update(p);
    }

    @ApiOperation(value = "Allows you to delete an employee with provided id.")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted the employee with provided id."),
            @ApiResponse(code = 401, message = "You are not authorized to delete employee"),
            @ApiResponse(code = 403, message = "Deleting this employee is forbidden"),
            @ApiResponse(code = 404, message = "The employee you were trying to reach is not found") })
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void delete(@PathVariable final long id) {
    		personServices.remove(id);
    }
}