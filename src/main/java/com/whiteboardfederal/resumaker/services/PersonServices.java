package com.whiteboardfederal.resumaker.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.whiteboardfederal.resumaker.model.Employee;
import com.whiteboardfederal.resumaker.repository.EmployeeRepository;

@Service
public class PersonServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> findAll() {
    		return employeeRepository.findAll();
    }
	
    public Employee get(long id) {
    		//return employeeRepository.findById(id).orElseThrow(() -> new EntityMissingException("employee", id));
    		return null;
    }
    
    public Employee save(Employee p) {
    		//@TODO - Ensure that the ID is not set
    		return employeeRepository.save(p);
    }
    
    public void update(Employee p) {
    		//@TODO - Add business logic to check for this
		employeeRepository.save(p);
    }
    
    public void remove(long id) {
    		employeeRepository.deleteById(id);
    }
    
}
