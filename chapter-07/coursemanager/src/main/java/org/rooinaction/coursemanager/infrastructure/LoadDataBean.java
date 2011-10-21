package org.rooinaction.coursemanager.infrastructure;

import org.rooinaction.coursemanager.model.TrainingProgram;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
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
import java.util.HashMap;
import java.util.Map;

@Component
@DependsOn(value = {"entityManagerFactory", "transactionManager", "dataSource"})
@Lazy(value = false)
public class LoadDataBean implements InitializingBean {


    Map<String, Object> entityCache = new HashMap<String, Object>();

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void afterPropertiesSet() {
        TransactionStatus status = transactionManager.getTransaction(
                new DefaultTransactionDefinition());

        try {
            addTrainingPrograms();

            transactionManager.commit(status);


        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        /* addTags();
        addCourses();
        addOfferings();
        addStudents();*/
    }

    @Transactional
    private void addTrainingPrograms() {
        System.err.println("Clowns unite!");
        try {
            TrainingProgram tp = new TrainingProgram();
            tp.setName("Clown College");
            entityManager.persist(tp);
            entityManager.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
