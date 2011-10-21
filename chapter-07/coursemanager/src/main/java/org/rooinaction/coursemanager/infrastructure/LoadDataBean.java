package org.rooina.coursemanager.infrastructure;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimePrinter;
import org.rooina.coursemanager.model.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionManager;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.*;

@Component
@DependsOn(value = {"entityManagerFactory", "transactionManager", "dataSource"})
@Lazy(value = false)
public class LoadDataBean implements InitializingBean {


    Map<String, Object> entityCache = new HashMap<String, Object>();

    @PersistenceContext
    private EntityManager entityManager;
    
    private DateTimeParser parser;


    @Autowired
    private PlatformTransactionManager transactionManager;

    private TrainingProgram trainingProgram;
    private Course course;
    private Set<Tag> tags;
    private Set<Offering> offerings;
    private Set<Student> students;
    private Instructor instructor;

    private Calendar calendar;
    
    public void afterPropertiesSet() {
        
        calendar = GregorianCalendar.getInstance();
        setupData();
    }
    
    public void setupData() {
        TransactionStatus status = transactionManager.getTransaction(
                new DefaultTransactionDefinition());
        try {
            addTrainingPrograms();
            addTags();
            addCourse();
            addInstructor();
            addOfferings();
            addStudents();

            transactionManager.commit(status);


        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
    }
    
    private void addTrainingPrograms() throws Exception {
        trainingProgram = new TrainingProgram();
        trainingProgram.setName("Clown College");
        entityManager.persist(trainingProgram);
        entityManager.flush();
    }
    
    private void addTags() throws Exception {
        
        Tag tag1 = new Tag();
        tag1.setTag("course");
        tag1.persist();
        tags.add(tag1);
        
        Tag tag2 = new Tag();
        tag2.setTag("interesting");
        tag2.persist();
        tags.add(tag2);                
    }
    
    private void addCourse() throws Exception {
        course = new Course();
        course.setName("Applying Makeup");
        course.setCost(new BigDecimal("100.0"));
        course.setCourseType(CourseTypeEnum.SEMINAR);
        course.setDescription("You'll learn the secrets of the masters.  Apply makeup like Bello");
        course.persist();         
    }
    
    private void addInstructor() throws Exception {
        instructor = new Instructor();
        instructor.setFirstName("Bobo");
        instructor.setMiddleNameOrInitial("D");        
        instructor.setLastName("Clown");
        instructor.setActive(true);
        instructor.setTaxNumber("555-55-5555");
        instructor.setAddressLine1("1 Clown Blvd.");
        instructor.setCity("Clownville");
        instructor.setStateCode("NJ");
        instructor.setPostalCode("12345");
        instructor.persist();

    }
    
    private void addOfferings() throws Exception {
        
        Offering offering1 = new Offering();
        offering1.setCourse(course);
        offering1.setInstructor(instructor);
        calendar.set(2015, 1, 1);
        offering1.setRunDate(calendar.getTime());
        offering1.persist();

        Offering offering2 = new Offering();
        offering2.setCourse(course);
        offering2.setInstructor(instructor);
        calendar.set(2016, 1, 1);
        offering2.setRunDate(calendar.getTime());
        offering2.persist();
        
    }
    
    private void addStudents() throws Exception {
        Student student1 = new Student();
        student1.setFirstName("JoJo");
        student1.setMiddleNameOrInitial("X");
        student1.setLastName("Silly-Straw");
        student1.setDietaryRestrictions("No sand");
        student1.setEmergencyContactInfo("555-555-1212");
        student1.setEmergencyContactName("Mama Silly");
        student1.setAddressLine1("100 Bendy Straw Lane");
        student1.setAddressLine2("P.O. Box 500");
        student1.setCity("Happy and Sadville");
        student1.setStateCode("PA");
        student1.setEmailAddress("not.a.real.address@clown.net");
        student1.persist();
    }
    
    



}
