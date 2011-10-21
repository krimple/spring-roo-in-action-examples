package com.rooina.samples.security.model.security;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "security_authorities")
@Entity
public class Authority {

    @NotNull
    @Size(min = 8, max = 50)
    @Pattern(regexp = "^ROLE_[A-Z]*")
    private String authority;
}
