package org.rooinaction.coursemanager.service;

import java.math.BigDecimal;


public interface TaxCalcService {
	BigDecimal calculateTax(BigDecimal price);
}
