package com.springsource.votesecure.domain.security;

import javax.persistence.Entity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Table;
import com.springsource.votesecure.domain.security.Users;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.springsource.votesecure.domain.security.Authorities;

@Entity
@RooJavaBean
@RooToString
@RooEntity
@Table(name = "security_role_user")
public class UserAuthority {

    @ManyToOne(targetEntity = Users.class)
    @JoinColumn
    private Users users;

    @ManyToOne(targetEntity = Authorities.class)
    @JoinColumn
    private Authorities authorities;
}
