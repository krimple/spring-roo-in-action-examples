package org.rooinaction.coursemanager.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(inheritanceType = "TABLE_PER_CLASS")
public abstract class Person {

    @Size(min = 1, max = 30)
    private String firstName;

    @Size(min = 1, max = 30)
    private String middleNameOrInitial;

    @NotNull
    @Size(min = 1, max = 60)
    private String addressLine1;

    @Size(min = 0, max = 60)
    private String addressLine2;

    @Size(min = 0, max = 40)
    private String city;

    @Size(min = 2, max = 2)
    private String stateCode;

    @NotNull
    @Size(min = 1, max = 10)
    private String postalCode;

    @NotNull
    @Size(min = 1, max = 80)
    private String emailAddress;
}
