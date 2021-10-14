package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactLoginSizeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactLoginSizeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactLoginSizeConstraint {

    String message() default "Логин должен содержать только Латиницу с длиной от 4 до 25";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
