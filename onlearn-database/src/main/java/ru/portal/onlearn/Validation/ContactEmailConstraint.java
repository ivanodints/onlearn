package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactEmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactEmailConstraint {

    String message() default "Некорректный email";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
