package com.rooina.samples.security.model.security;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Table;
import javax.persistence.Entity;
import com.rooina.samples.security.model.security.Principal;
import javax.persistence.ManyToOne;
import com.rooina.samples.security.model.security.Authority;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "security_role_assignments")
@Entity
public class AuthorityPrincipalAssignment {

    @ManyToOne
    private Principal principal;

    @ManyToOne
    private Authority authority;
}
