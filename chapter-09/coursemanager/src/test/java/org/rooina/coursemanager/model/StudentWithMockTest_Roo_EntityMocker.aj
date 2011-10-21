package org.rooina.coursemanager.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
//import org.powermock.api.mockito.PowerMockito;
//import org.powermock.modules.junit4.PowerMockRunner;
import org.rooina.coursemanager.model.SingleEventDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

privileged aspect StudentTest_Roo_EntityMocker {

    private Student StudentWithMockTest.student;

    //declare @type: StudentWithMockTest: @RunWith(PowerMockRunner.class);


    @Before
    private void StudentWithMockTest.setUp() throws Exception {
        student = Mockito.mock(Student.class);
        //Mockito.doNothing().when(student).persist();

        Mockito.doNothing().when(student).flush();
        //PowerMockito.whenNew(Student.class).withNoArguments()
        //        .thenReturn(student);
    }
}