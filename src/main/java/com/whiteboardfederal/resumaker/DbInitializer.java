
package com.whiteboardfederal.resumaker;

import java.util.Date;

import com.whiteboardfederal.resumaker.entities.employee.model.Employee;
import com.whiteboardfederal.resumaker.entities.employee.repository.EmployeeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * Database initializer that populates the database with some initial bank
 * accounts using a JPA repository.
 * 
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(prefix = "spring.dbinit", name = "create", matchIfMissing = true)
public class DbInitializer implements CommandLineRunner {
  private final EmployeeRepository employeeRepository;

  public DbInitializer(final EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public void run(final String... strings) throws Exception {
    this.employeeRepository.deleteAll();

    Date creationDate = new Date();
    Employee employee1 = new Employee("Jarrett", "G", "Horton", "5555555555", "5555555555", "Software Engineer 1", "123 Test Street", "jhorton@whiteboardfederal.com", creationDate);

    this.employeeRepository.save(employee1);

    System.out.println(" -- Database has been initialized");
  }
}