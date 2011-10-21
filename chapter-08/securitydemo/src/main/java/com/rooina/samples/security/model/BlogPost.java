package com.rooina.samples.security.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Entity
public class BlogPost {

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private Date postDate;

    private String title;

    @Length(min = 1, max = 10000)
    private String post;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Blog blog;
}
