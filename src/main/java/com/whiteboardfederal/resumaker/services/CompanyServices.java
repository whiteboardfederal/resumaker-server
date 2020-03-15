package com.whiteboardfederal.resumaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Company;
import com.whiteboardfederal.resumaker.repository.CompanyRepository;

@Service
public class CompanyServices {
	
	@Autowired
	private CompanyRepository companyRepo;

	public List<Company> findAll() {
		return companyRepo.findAll();
	}
	
	public Company find(long id) throws EntityNotFoundException, InvalidFormException {
		if (id <= 0)
			throw new InvalidFormException("The provided ID for the company can not be zero or negative", "Submit a valid ID.");
		
    		return companyRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Company", String.valueOf(id)));
	}

	public Company save(Company company) {
		return companyRepo.save(company);
	}

}
