// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.rooinaction.coursemanager.model;

import java.lang.Long;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.rooinaction.coursemanager.model.Registration;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Registration_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Registration.entityManager;
    
    @Transactional
    public void Registration.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Registration.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Registration attached = Registration.findRegistration(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Registration.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Registration.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Registration Registration.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Registration merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
    public static final EntityManager Registration.entityManager() {
        EntityManager em = new Registration().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Registration.countRegistrations() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Registration o", Long.class).getSingleResult();
    }
    
    public static List<Registration> Registration.findAllRegistrations() {
        return entityManager().createQuery("SELECT o FROM Registration o", Registration.class).getResultList();
    }
    
    public static Registration Registration.findRegistration(Long id) {
        if (id == null) return null;
        return entityManager().find(Registration.class, id);
    }
    
    public static List<Registration> Registration.findRegistrationEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Registration o", Registration.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
