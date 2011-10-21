package org.rooina.coursemanager.service;

import java.math.BigDecimal;


public interface TaxCalcService {
	BigDecimal calculateTax(BigDecimal price);
}
