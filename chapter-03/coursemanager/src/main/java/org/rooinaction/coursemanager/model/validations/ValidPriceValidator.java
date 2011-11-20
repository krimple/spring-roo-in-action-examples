package org.rooinaction.coursemanager.model.validations;

import java.math.BigDecimal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPriceValidator implements
        ConstraintValidator<IsValidPrice, BigDecimal> {

  private static final BigDecimal INCREMENT = new BigDecimal("0.05");

  @Override
  public void initialize(IsValidPrice constraintAnnotation) {
  }

  @Override
  public boolean isValid(BigDecimal value,
          ConstraintValidatorContext context) {

    if (value == null)
      return true;

    return value.remainder(INCREMENT).compareTo(BigDecimal.ZERO) == 0;
  }

}