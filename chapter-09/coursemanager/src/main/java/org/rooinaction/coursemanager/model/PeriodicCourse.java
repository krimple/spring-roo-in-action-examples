package org.rooina.coursemanager.model;

import javax.persistence.DiscriminatorValue;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.rooina.coursemanager.model.FrequencyType;
import javax.validation.constraints.NotNull;
import javax.persistence.Enumerated;

@RooJavaBean
@RooToString
@RooEntity
@DiscriminatorValue("PERIODIC")
public class PeriodicCourse extends Offering {

	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date startDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FrequencyType frequency;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date endDate;
}
