package org.rooinaction.taskmanager.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooEntity
public class Task {
	
    @NotNull
    @Size(max = 40)
    private String task;

    @Value("false")
    private Boolean completed;
    

	public String getTask() {
        return this.task;
    }

	public void setTask(String task) {
        this.task = task;
    }

	public Boolean getCompleted() {
        return this.completed;
    }

	public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

	@PersistenceContext
    transient EntityManager entityManager;

	@Transactional
    public void persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }

	@Transactional
    public void remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Task attached = Task.findTask(this.id);
            this.entityManager.remove(attached);
        }
    }

	@Transactional
    public void flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }

	@Transactional
    public Task merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Task merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }

	public static final EntityManager entityManager() {
        EntityManager em = new Task().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }

	public static long countTasks() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Task o", Long.class).getSingleResult();
    }

	public static List<Task> findAllTasks() {
        return entityManager().createQuery("SELECT o FROM Task o", Task.class).getResultList();
    }

	public static Task findTask(Long id) {
        if (id == null) return null;
        return entityManager().find(Task.class, id);
    }

	public static List<Task> findTaskEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Task o", Task.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Completed: ").append(getCompleted()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Task: ").append(getTask()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }
}
