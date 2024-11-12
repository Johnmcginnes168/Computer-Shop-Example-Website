package com.example.demo.validators;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;


@Constraint(validatedBy = {PartInventoryValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidPartInventory {
    String message() default "Inventory can not be higher than maximum inventory";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
