
package com.whiteboardfederal.resumaker.utils;

import java.util.Date;

import com.whiteboardfederal.resumaker.model.Education;
import com.whiteboardfederal.resumaker.repository.EducationRepository;
import com.whiteboardfederal.resumaker.model.Person;
import com.whiteboardfederal.resumaker.repository.PersonRepository;
import com.whiteboardfederal.resumaker.model.WorkHistory;
import com.whiteboardfederal.resumaker.repository.WorkHistoryRepository;
import com.whiteboardfederal.resumaker.model.RefCertification;
import com.whiteboardfederal.resumaker.repository.RefCertificationRepository;
import com.whiteboardfederal.resumaker.model.Skills;
import com.whiteboardfederal.resumaker.repository.SkillsRepository;

import com.whiteboardfederal.resumaker.model.RefDegree;
import com.whiteboardfederal.resumaker.repository.RefDegreeRepository;

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
  private final PersonRepository personRepository;
  private final WorkHistoryRepository workHistoryRepository;
  private final EducationRepository educationRepository;
  private final RefCertificationRepository refCertificationRepository;
  private final RefDegreeRepository refDegreeRepository;
  private final SkillsRepository skillsRepository;

  public DbInitializer(final PersonRepository personRepository, final WorkHistoryRepository workHistoryRepository,
      final EducationRepository educationRepository, final RefDegreeRepository refDegreeRepository, final SkillsRepository skillsRepository,
      final RefCertificationRepository refCertificationRepository) {
    this.personRepository = personRepository;
    this.workHistoryRepository = workHistoryRepository;
    this.educationRepository = educationRepository;
    this.refDegreeRepository = refDegreeRepository;
    this.skillsRepository = skillsRepository;
    this.refCertificationRepository = refCertificationRepository;
  }

  @Override
  public void run(final String... strings) throws Exception {
    this.personRepository.deleteAll();
    this.workHistoryRepository.deleteAll();
    this.educationRepository.deleteAll();
    this.refCertificationRepository.deleteAll();
    this.skillsRepository.deleteAll();
    this.refDegreeRepository.deleteAll();

    Date creationDate = new Date();
    Person person = new Person("Jarrett", "Garner", "Horton", "5555555555", "5555555555", "Software Engineer 1",
        "123 Test Street", "jhorton@whiteboardfederal.com", creationDate);
    WorkHistory workHistory = new WorkHistory(1L, "Anthem Inc.", "Data Center Intern", creationDate, creationDate);
    Education education = new Education(1L, "Bridgewater College", "CS Bachelor");
    RefCertification refCertification = new RefCertification("AWS: Practictioner", "Some AMAZON THING", 3);

    this.personRepository.save(person);
    this.workHistoryRepository.save(workHistory);
    this.educationRepository.save(education);
    this.refCertificationRepository.save(refCertification);

    System.out.println(" -- Database has been initialized with Person and WorkHistory");
  }
}