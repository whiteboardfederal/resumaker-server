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
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Person;
import com.whiteboardfederal.resumaker.services.PersonServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/person")
class PersonController extends BaseController {

    
    @Autowired
    private PersonServices personServices;

    @ApiOperation(value = "Allows you to find all the people provided.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved people."),
            @ApiResponse(code = 401, message = "You are not authorized to view people"),
            @ApiResponse(code = 403, message = "Accessing this people is forbidden"),
            @ApiResponse(code = 404, message = "The people you were trying to reach are not found") })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Person> findAll() {
        return personServices.findAll();
    }

    @ApiOperation(value = "Allows you to find the person provided by suppied ID.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved person."),
            @ApiResponse(code = 401, message = "You are not authorized to view person"),
            @ApiResponse(code = 403, message = "Accessing this person is forbidden"),
            @ApiResponse(code = 404, message = "The person you were trying to reach is not found") })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    Person get(@PathVariable final long id) throws InvalidFormException, EntityNotFoundException {
    		return personServices.get(id);
    }

    @ApiOperation(value = "Allows you to create a person.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully created person."),
            @ApiResponse(code = 401, message = "You are not authorized to create person"),
            @ApiResponse(code = 403, message = "Creating this person is forbidden") })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Person create(@RequestBody final Person person) throws InvalidFormException {
        return personServices.save(person);
    }

    @ApiOperation(value = "Allows you to update an person with provided id.")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the person with provided id."),
            @ApiResponse(code = 401, message = "You are not authorized to update person"),
            @ApiResponse(code = 403, message = "Updating this person is forbidden"),
            @ApiResponse(code = 404, message = "The person you were trying to reach is not found") })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void overwrite(@RequestBody final Person person) throws InvalidFormException, EntityNotFoundException {
    		personServices.update(person);
    }

    @ApiOperation(value = "Allows you to delete an person with provided id.")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted the person with provided id."),
            @ApiResponse(code = 401, message = "You are not authorized to delete person"),
            @ApiResponse(code = 403, message = "Deleting this person is forbidden"),
            @ApiResponse(code = 404, message = "The person you were trying to reach is not found") })
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void delete(@PathVariable final long id) throws InvalidFormException, EntityNotFoundException {
    		personServices.remove(id);
    }
}