package com.rooina.samples.security.model;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class Blog {

    @Size(min = 1, max = 80)
    private String blogName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "blog")
    private Set<com.rooina.samples.security.model.BlogPost> posts = 
    	new java.util.HashSet<com.rooina.samples.security.model.BlogPost>();
}
