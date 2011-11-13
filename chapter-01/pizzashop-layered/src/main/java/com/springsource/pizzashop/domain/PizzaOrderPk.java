package com.springsource.pizzashop.domain;

import org.springframework.roo.addon.equals.RooEquals;
import org.springframework.roo.addon.jpa.identifier.RooIdentifier;
import org.springframework.roo.addon.tostring.RooToString;

@RooToString
@RooEquals
@RooIdentifier
public final class PizzaOrderPk {

    private String shopCountry;

    private String shopCity;

    private String shopName;
}
