package org.rooina.coursemanager.service;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

public class DefaultTaxCalcServiceTest {

    private DefaultTaxCalcService defaultTaxCalcService = 
    	new DefaultTaxCalcService(new BigDecimal("0.02"));

    @Test
    public void calculateTax() {
        BigDecimal price = new BigDecimal("50");
        BigDecimal taxAmount = defaultTaxCalcService.calculateTax(price);
        Assert.assertEquals("Tax rate invalid", new BigDecimal("1.00"), taxAmount);
    }
}
