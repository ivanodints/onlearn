package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactIsEmptyEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactIsEmptyEmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactIsEmptyEmailConstraint {

    String message() default "Данный email уже используется другим пользователем";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
