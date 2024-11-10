package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType.*;
import java.lang.annotation.RetentionPolicy;


@Constraint(validatedBy = {PartInventoryMinimumValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPartInventoryMinimum {
    String message() default "Inventory can not be lower than minimum inventory";
    Class [] groups() default {};
    Class [] payload() default {};

}
