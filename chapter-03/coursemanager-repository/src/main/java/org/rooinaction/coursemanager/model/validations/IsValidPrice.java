package org.rooinaction.coursemanager.model.validations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@NotNull
@DecimalMin("0.0")
@DecimalMax("99999.99")
@Digits(integer = 5, fraction = 2)
@Documented
@Constraint(validatedBy = ValidPriceValidator.class) 
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidPrice {
  String message() default "Price is invalid - must be between 0 and 10,000 with fractional values divisible by .";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}