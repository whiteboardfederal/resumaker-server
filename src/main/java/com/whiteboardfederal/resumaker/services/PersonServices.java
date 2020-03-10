package com.whiteboardfederal.resumaker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Person;
import com.whiteboardfederal.resumaker.repository.PersonRepository;

@Service
public class PersonServices {

    @Autowired
    protected PersonRepository personRepository;
    
    
    public List<Person> findAll() {
    		return personRepository.findAll();
    }
	
    public Person get(long id) throws InvalidFormException, EntityNotFoundException {
		if (id <= 0)
			throw new InvalidFormException("The provided ID for the person can not be zero or negative", "Submit a valid ID.");
		
    		return personRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Person", String.valueOf(id)));
    }
    
    public void remove(long id) throws InvalidFormException, EntityNotFoundException {
		//Here we leverage our get call since it has all of the look-up logic to ensure that the entity exist
    		get(id);
    		personRepository.deleteById(id);
    }
    
    public Person save(Person emp) throws InvalidFormException {
    		if (emp == null)
    			throw new InvalidFormException("A null person cannot be submitted", "Submit a valid person");
    		
    		if (emp.getId() != null && emp.getId() > 0)
    			throw new InvalidFormException("You cannot set the unique ID of a person when creating them.", "Remove the ID field from the person and re-submit to let the application create and assign an ID.");

    		
    		try {
    			return personRepository.save(emp);
    		} catch (org.springframework.transaction.TransactionSystemException ex) {
    			throw new InvalidFormException("One or more key values in your submission were missing or malformed", "Review the documenation and correct what went wrong", ex);
    		}
    }
    
    public void update(Person emp) throws InvalidFormException, EntityNotFoundException {
		if (emp == null)
			throw new InvalidFormException("A null person cannot be updated", "Please update a valid person");
		
		if (emp.getId() == null)
			throw new InvalidFormException("The unique ID of the person you're attempting to update cannot be null.", "Submit a non-null ID field for the person along with the rest of the request.");
		
		//Here we leverage our get call since it has all of the look-up logic to ensure that the entity exist
		get(emp.getId());
		
		try {
			personRepository.save(emp);
		} catch (Exception ex) {
			throw new InvalidFormException("One or more key values in your submission were missing or malformed", "Review the documenation and correct what went wrong", ex);
		}
    }
    
    
}
