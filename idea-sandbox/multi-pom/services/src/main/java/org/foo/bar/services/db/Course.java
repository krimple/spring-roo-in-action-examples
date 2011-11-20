package org.foo.bar.services.db;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity
@RooEquals
public class Course {

    private String name;

    @DecimalMin("0.0")
    private BigDecimal cost;

    private short duration;
}
