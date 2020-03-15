
package com.whiteboardfederal.resumaker.utils;

import com.whiteboardfederal.resumaker.model.*;
import com.whiteboardfederal.resumaker.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Database initializer that populates the database with some initial bank
 * accounts using a JPA repository.
 * 
 * This component is started only when app.db-init property is set to true
 */
@Component
@ConditionalOnProperty(prefix = "spring.dbinit", name = "create", matchIfMissing = true)
public class DbInitializer implements CommandLineRunner {
  private final RefCertificationRepository refCertificationRepository;
  private final RefDegreeRepository refDegreeRepository;
  private final RefSkillRepository refSkillRepository;
  private final PersonRepository personRepository;
  private final WorkHistoryRepository workHistoryRepository;
  private final EducationRepository educationRepository;
  private final SkillsRepository skillsRepository;

  public DbInitializer(
          final PersonRepository personRepository,
          final WorkHistoryRepository workHistoryRepository,
          final EducationRepository educationRepository,
          final RefDegreeRepository refDegreeRepository,
          final SkillsRepository skillsRepository,
          final RefCertificationRepository refCertificationRepository,
          final RefSkillRepository refSkillRepository) {
    this.refDegreeRepository = refDegreeRepository;
    this.refCertificationRepository = refCertificationRepository;
    this.refSkillRepository = refSkillRepository;
    this.personRepository = personRepository;
    this.workHistoryRepository = workHistoryRepository;
    this.educationRepository = educationRepository;
    this.skillsRepository = skillsRepository;
  }

  @Override
  public void run(final String... strings) throws Exception {
    this.refDegreeRepository.deleteAll();
    this.refCertificationRepository.deleteAll();
    this.refSkillRepository.deleteAll();
    this.personRepository.deleteAll();
    this.workHistoryRepository.deleteAll();
    this.educationRepository.deleteAll();
    this.skillsRepository.deleteAll();

    Date creationDate = new Date();
    //References
    RefCertification refCertification = new RefCertification("AWS: Practictioner", "Some AMAZON THING", 3);
    RefSkill refSkill = new RefSkill("val", "val");

    //Entities
    Person person = new Person("Jarrett", "Garner", "Horton", "5555555555", "5555555555", "Software Engineer 1",
        "123 Test Street", "jhorton@whiteboardfederal.com", creationDate);
    WorkHistory workHistory = new WorkHistory(1L, "Anthem Inc.", "Data Center Intern", creationDate, creationDate);
    Education education = new Education(1L, "Bridgewater College", "CS Bachelor");
    Skills skills = new Skills(person, refSkill, 5.5);

    this.refCertificationRepository.save(refCertification);
    this.refSkillRepository.save(refSkill);
    this.personRepository.save(person);
    this.workHistoryRepository.save(workHistory);
    this.educationRepository.save(education);
    this.skillsRepository.save(skills);

    System.out.println(" -- Database has been initialized with Person and WorkHistory");
  }
}