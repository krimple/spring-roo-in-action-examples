package org.rooina.coursemanager.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RooJavaBean
@RooToString
@RooEntity(versionField = "", table = "invoice")
public class Invoice {
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal amount;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style="S-")
    @Column(name = "due_date")
    private Date dueDate;

    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "student_name")
    private String studentName;

    @Email
    @Size(min = 1, max = 80)
    @Column(name = "email_address")
    private String emailAddress;
    
    @OneToMany
    @JoinColumn(name = "invoice_id")
    private Set<Payment> payments = new HashSet<Payment>();
}

/*
        <column name="invoice_id" primaryKey="true" required="true" size="10" type="4,INT"/>
        <column name="amount" primaryKey="false" required="true" size="7,2" type="3,DECIMAL"/>
        <column name="due_date" primaryKey="false" required="true" size="19" type="93,DATETIME"/>
        <column name="student_name" primaryKey="false" required="true" size="80" type="12,VARCHAR"/>
        <column name="email_address" primaryKey="false" required="true" size="80" type="12,VARCHAR"/>
        <foreign-key foreignTable="payment" name="fk_payment_invoice1" onDelete="none" onUpdate="none">
            <option key="exported" value="true"/>
            <reference foreign="invoice_id" local="invoice_id"/>
        </foreign-key>
        <unique name="PRIMARY">
            <unique-column name="invoice_id"/>
        </unique>

 */
