package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactSexValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactSexValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactSexConstraint {

    String message() default "Некорректно указан пол." +
            " Допускается ввод Кириллици или Латиницы, длина от 3 до 7.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
