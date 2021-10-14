package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNumberValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNumberConstraint {

    String message() default "Некорректный номер телефона или данный номер уже есть";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
