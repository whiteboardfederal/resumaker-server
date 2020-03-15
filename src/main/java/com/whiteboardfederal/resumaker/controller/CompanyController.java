package com.whiteboardfederal.resumaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Company;
import com.whiteboardfederal.resumaker.services.CompanyServices;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1/company")
class CompanyController {

	@Autowired
	private CompanyServices companyServices;

	@ApiOperation(value = "Pull back all companies currently saved in the system.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved all company entities."),
			@ApiResponse(code = 401, message = "You are not authorized to view company entities"),
			@ApiResponse(code = 403, message = "Viewing all companies are forbidden")
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Company> query() {
		return companyServices.findAll();
	}

	@ApiOperation(value = "Allows you to pull back the company tied to a given ID.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved company entity."),
			@ApiResponse(code = 401, message = "You are not authorized to view this company entity"),
			@ApiResponse(code = 403, message = "Accessing this company entity is forbidden"),
			@ApiResponse(code = 404, message = "The company entity you were trying to return is not found")
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Company get(@PathVariable final long id) throws EntityNotFoundException, InvalidFormException {
		return companyServices.find(id);
	}

	@ApiOperation(value = "Allows you to create a company entity.")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully created company entity."),
			@ApiResponse(code = 400, message = "You submitted an invalid payload to create this company, please review the error message and try again."),
			@ApiResponse(code = 401, message = "You are not authorized to create a company entity"),
			@ApiResponse(code = 403, message = "Creating this company entity is forbidden")
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Company create(@RequestBody Company company) {
		return companyServices.save(company);
	}
}