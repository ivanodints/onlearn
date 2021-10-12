package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactLoginValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactLoginValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactLoginConstraint {

    String message() default "Данный логин уже существует";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
