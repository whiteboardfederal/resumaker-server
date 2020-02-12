
package com.whiteboardfederal.resumaker.utils;

import java.util.Date;

import com.whiteboardfederal.resumaker.model.Education;
import com.whiteboardfederal.resumaker.repository.EducationRepository;
import com.whiteboardfederal.resumaker.model.Employee;
import com.whiteboardfederal.resumaker.repository.EmployeeRepository;
import com.whiteboardfederal.resumaker.model.WorkHistory;
import com.whiteboardfederal.resumaker.repository.WorkHistoryRepository;

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
  private final WorkHistoryRepository workHistoryRepository;
  private final EducationRepository educationRepository;

  public DbInitializer(final EmployeeRepository employeeRepository, final WorkHistoryRepository workHistoryRepository,
      final EducationRepository educationRepository) {
    this.employeeRepository = employeeRepository;
    this.workHistoryRepository = workHistoryRepository;
    this.educationRepository = educationRepository;
  }

  @Override
  public void run(final String... strings) throws Exception {
    this.employeeRepository.deleteAll();
    this.workHistoryRepository.deleteAll();
    this.educationRepository.deleteAll();

    Date creationDate = new Date();
    Employee employee = new Employee("Jarrett", "G", "Horton", "5555555555", "5555555555", "Software Engineer 1",
        "123 Test Street", "jhorton@whiteboardfederal.com", creationDate);
    WorkHistory workHistory = new WorkHistory(1L, "Anthem Inc.", "Data Center Intern", creationDate, creationDate);
    Education education = new Education(1L, "Bridgewater College", "CS Bachelor");

    this.employeeRepository.save(employee);
    this.workHistoryRepository.save(workHistory);
    this.educationRepository.save(education);

    System.out.println(" -- Database has been initialized with Employee and WorkHistory");
  }
}