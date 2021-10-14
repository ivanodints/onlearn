package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactNullValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNullValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNullConstraint {

    String message() default "Поле не может быть пустым";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
