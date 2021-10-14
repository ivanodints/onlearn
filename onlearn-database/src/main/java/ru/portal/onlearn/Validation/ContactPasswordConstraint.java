package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactPasswordValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactPasswordConstraint {

    String message() default "Некорректный пароль, минимальная длина пароля 7 символов. " +
            "Допустимые символы Латиница, 0-9 ~`@!#$%^&*={}_<>/?,()+";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
