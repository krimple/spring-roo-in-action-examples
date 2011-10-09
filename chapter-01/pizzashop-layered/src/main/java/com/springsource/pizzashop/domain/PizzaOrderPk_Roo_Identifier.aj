// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.springsource.pizzashop.domain;

import java.lang.Object;
import java.lang.String;
import javax.persistence.Embeddable;

privileged aspect PizzaOrderPk_Roo_Identifier {
    
    declare @type: PizzaOrderPk: @Embeddable;
    
    public PizzaOrderPk.new(String shopCountry, String shopCity, String shopName) {
        super();
        this.shopCountry = shopCountry;
        this.shopCity = shopCity;
        this.shopName = shopName;
    }

    private PizzaOrderPk.new() {
        super();
    }

    public String PizzaOrderPk.getShopCountry() {
        return this.shopCountry;
    }
    
    public String PizzaOrderPk.getShopCity() {
        return this.shopCity;
    }
    
    public String PizzaOrderPk.getShopName() {
        return this.shopName;
    }
    
    public boolean PizzaOrderPk.equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof PizzaOrderPk)) return false;
        PizzaOrderPk other = (PizzaOrderPk) obj;
        if (shopCountry == null) {
            if (other.shopCountry != null) return false;
        } else if (!shopCountry.equals(other.shopCountry)) return false;
        if (shopCity == null) {
            if (other.shopCity != null) return false;
        } else if (!shopCity.equals(other.shopCity)) return false;
        if (shopName == null) {
            if (other.shopName != null) return false;
        } else if (!shopName.equals(other.shopName)) return false;
        return true;
    }
    
    public int PizzaOrderPk.hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + (shopCountry == null ? 0 : shopCountry.hashCode());
        result = prime * result + (shopCity == null ? 0 : shopCity.hashCode());
        result = prime * result + (shopName == null ? 0 : shopName.hashCode());
        return result;
    }
    
}
