package org.rooina.coursemanager.model;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(PowerMockRunner.class)
public class StudentWithMockTest {

    @Test
    public void testPersist() {
        System.err.println("I am testing!!! ");
        StudentDataOnDemand studentDod = new StudentDataOnDemand();
        Student student = studentDod.getNewTransientStudent(0);
        student.persist();
    }
}
