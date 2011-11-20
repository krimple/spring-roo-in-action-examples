package com.springsource.pizzashop.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaEntity(identifierType = PizzaOrderPk.class)
@RooJson(deepSerialize = true)
public class PizzaOrder {

    @NotNull
    @Size(min = 2)
    private String name;

    @Size(max = 30)
    private String address;

    private BigDecimal total;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date deliveryDate;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Pizza> pizzas = new HashSet<Pizza>();
}
