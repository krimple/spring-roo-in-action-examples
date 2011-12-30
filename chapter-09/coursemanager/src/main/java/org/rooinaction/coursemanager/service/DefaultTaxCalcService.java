package org.rooina.coursemanager.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

public class DefaultTaxCalcService implements TaxCalcService {

	private BigDecimal taxRate;

	@Autowired
	public DefaultTaxCalcService(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	@Override
	public BigDecimal calculateTax(BigDecimal price) {
		return price.multiply(taxRate);

	}
}
