package org.rooinaction.coursemanager.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.transaction.annotation.Transactional;

@Configurable
@Entity
@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findCoursesByNameLike", "findCoursesByCourseTypeAndRunDateBetween" })
public class Course {

    @Column(name = "course_name")
    @Size(min = 1, max = 60)
    private String name;

    @NotNull
    @Size(max = 1000)
    private String description;

    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("99999.99")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal listPrice;

    @NotNull
    @Column(name = "max_capacity")
    @Min(1L)
    @Max(9999L)
    private Integer maximumCapacity;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date runDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CourseTypeEnum courseType;

    @ManyToOne
    private TrainingProgram trainingProgram;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private Set<Tag> tags = new HashSet<Tag>();
  @PersistenceContext
  transient EntityManager entityManager;
  @Version
  @Column(name = "version")
  private Integer version;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  public static final EntityManager entityManager() {
      EntityManager em = new Course().entityManager;
      if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
      return em;
  }

  public static long countCourses() {
      return entityManager().createQuery("SELECT COUNT(o) FROM Course o", Long.class).getSingleResult();
  }

  public static List<Course> findAllCourses() {
      return entityManager().createQuery("SELECT o FROM Course o", Course.class).getResultList();
  }

  public static Course findCourse(Long id) {
      if (id == null) return null;
      return entityManager().find(Course.class, id);
  }

  public static List<Course> findCourseEntries(int firstResult, int maxResults) {
      return entityManager().createQuery("SELECT o FROM Course o", Course.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
  }

  public static TypedQuery<Course> findCoursesByNameLike(String name) {
      if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
      name = name.replace('*', '%');
      if (name.charAt(0) != '%') {
          name = "%" + name;
      }
      if (name.charAt(name.length() - 1) != '%') {
          name = name + "%";
      }
      EntityManager em = Course.entityManager();
      TypedQuery<Course> q = em.createQuery("SELECT o FROM Course AS o WHERE LOWER(o.name) LIKE LOWER(:name)", Course.class);
      q.setParameter("name", name);
      return q;
  }

  public static TypedQuery<Course> findCoursesByCourseTypeAndRunDateBetween(CourseTypeEnum courseType, Date minRunDate, Date maxRunDate) {
      if (courseType == null) throw new IllegalArgumentException("The courseType argument is required");
      if (minRunDate == null) throw new IllegalArgumentException("The minRunDate argument is required");
      if (maxRunDate == null) throw new IllegalArgumentException("The maxRunDate argument is required");
      EntityManager em = Course.entityManager();
      TypedQuery<Course> q = em.createQuery("SELECT o FROM Course AS o WHERE o.courseType = :courseType AND o.runDate BETWEEN :minRunDate AND :maxRunDate", Course.class);
      q.setParameter("courseType", courseType);
      q.setParameter("minRunDate", minRunDate);
      q.setParameter("maxRunDate", maxRunDate);
      return q;
  }

  @Transactional
  public Course merge() {
      if (this.entityManager == null) this.entityManager = entityManager();
      Course merged = this.entityManager.merge(this);
      this.entityManager.flush();
      return merged;
  }

  @Transactional
  public void clear() {
      if (this.entityManager == null) this.entityManager = entityManager();
      this.entityManager.clear();
  }

  @Transactional
  public void flush() {
      if (this.entityManager == null) this.entityManager = entityManager();
      this.entityManager.flush();
  }

  @Transactional
  public void remove() {
      if (this.entityManager == null) this.entityManager = entityManager();
      if (this.entityManager.contains(this)) {
          this.entityManager.remove(this);
      } else {
          Course attached = Course.findCourse(this.id);
          this.entityManager.remove(attached);
      }
  }

  @Transactional
  public void persist() {
      if (this.entityManager == null) this.entityManager = entityManager();
      this.entityManager.persist(this);
  }

  public void setRunDate(Date runDate) {
      this.runDate = runDate;
  }

  public Date getRunDate() {
      return this.runDate;
  }

  public void setMaximumCapacity(Integer maximumCapacity) {
      this.maximumCapacity = maximumCapacity;
  }

  public Integer getMaximumCapacity() {
      return this.maximumCapacity;
  }

  public void setListPrice(BigDecimal listPrice) {
      this.listPrice = listPrice;
  }

  public BigDecimal getListPrice() {
      return this.listPrice;
  }

  public void setDescription(String description) {
      this.description = description;
  }

  public String getDescription() {
      return this.description;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getName() {
      return this.name;
  }

  public CourseTypeEnum getCourseType() {
      return this.courseType;
  }

  public void setCourseType(CourseTypeEnum courseType) {
      this.courseType = courseType;
  }

  public TrainingProgram getTrainingProgram() {
      return this.trainingProgram;
  }

  public void setTrainingProgram(TrainingProgram trainingProgram) {
      this.trainingProgram = trainingProgram;
  }

  public Set<Tag> getTags() {
      return this.tags;
  }

  public void setTags(Set<Tag> tags) {
      this.tags = tags;
  }

  public void setVersion(Integer version) {
      this.version = version;
  }

  public Integer getVersion() {
      return this.version;
  }

  public void setId(Long id) {
      this.id = id;
  }

  public Long getId() {
      return this.id;
  }

  public String toString() {
      return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }
}
