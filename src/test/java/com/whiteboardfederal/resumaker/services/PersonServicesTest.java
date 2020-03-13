package com.whiteboardfederal.resumaker.services;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.whiteboardfederal.resumaker.exceptions.EntityNotFoundException;
import com.whiteboardfederal.resumaker.exceptions.InvalidFormException;
import com.whiteboardfederal.resumaker.model.Person;
import com.whiteboardfederal.resumaker.repository.PersonRepository;

public class PersonServicesTest {
	
	private static PersonServices createPersonServices() {
		PersonServices personServices = new PersonServices();
		personServices.personRepository = mock(PersonRepository.class);	//Create a mock of your JPA object (since it's an interface it'll be easy)
		return personServices;
	}
	
	@Test(expected=InvalidFormException.class)
	public void testGetNegativeId() throws InvalidFormException, EntityNotFoundException {
		PersonServices service = createPersonServices();
		service.get(-1);
	}
	
	@Test(expected=InvalidFormException.class)
	public void testGetZeroId() throws InvalidFormException, EntityNotFoundException {
		PersonServices service = createPersonServices();
		service.get(-1);
	}

	@Test(expected=EntityNotFoundException.class)
	public void testGetIdNotFoundInDatabase() throws InvalidFormException, EntityNotFoundException {
		PersonServices service = createPersonServices();
		
		//Set up your assumptions here
		when(service.personRepository.findById(100L)).thenThrow(EntityNotFoundException.class);
		
		service.get(100L);
	}
	
	@Test
	public void testGetIdValid() throws InvalidFormException, EntityNotFoundException {
		PersonServices service = createPersonServices();

		//Set up your assumptions here
		when(service.personRepository.findById(1L)).thenReturn(Optional.of(new Person()));
		
		//Now hit play
		Person foundPerson = service.get(1L);
		
		//Now check  to make sure your assumptions are correct
		Assert.assertNotNull(foundPerson);
	}
	
	@Test(expected=InvalidFormException.class)
	public void testSavePersonBadField() throws InvalidFormException, EntityNotFoundException {
		PersonServices service = createPersonServices();
		
		//Create your submission object/form/person
		Person p = new Person();
		p.setFirstName("Doesn't");
		p.setLastName("Matter");

		//Set up your assumptions here
		when(service.personRepository.save(p)).thenThrow(org.springframework.transaction.TransactionSystemException.class);
		
		//Now hit play
		service.save(p);
	}
}
