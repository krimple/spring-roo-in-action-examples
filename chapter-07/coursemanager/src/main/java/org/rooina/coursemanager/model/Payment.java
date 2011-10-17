package org.rooina.coursemanager.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.displaystring.RooDisplayString;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@RooJavaBean
@RooToString
@RooEntity(identifierType = PaymentPK.class, versionField = "", table = "payment")
@RooDisplayString
public class Payment {

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "SS")
    private Date paymentDate;

    @ManyToOne(optional = false)
    private Invoice invoice;

}

/* 
        <column name="payment_id" primaryKey="true" required="true" size="10" type="4,INT"/>
        <column name="amount" primaryKey="false" required="true" size="7,2" type="3,DECIMAL"/>
        <column name="payment_date" primaryKey="false" required="true" size="19" type="93,DATETIME"/>
        <column name="invoice_id" primaryKey="true" required="true" size="10" type="4,INT"/>
        <foreign-key foreignTable="invoice" name="fk_payment_invoice1" onDelete="none" onUpdate="none">
            <option key="exported" value="false"/>
            <reference foreign="invoice_id" local="invoice_id"/>
        </foreign-key>
        <unique name="PRIMARY">
            <unique-column name="payment_id"/>
            <unique-column name="invoice_id"/>
        </unique>
        <index name="fk_payment_invoice1">
            <index-column name="invoice_id"/>
        </index>

 */
