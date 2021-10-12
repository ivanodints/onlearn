package ru.portal.onlearn.Validation;

import ru.portal.onlearn.Validation.Validators.ContactNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ContactNameConstraint {

    String message() default "Неверно заполнено поле, допустимы как Кирилица так и Латиница," +
            " поле не меньше 4 и не больше 25";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
