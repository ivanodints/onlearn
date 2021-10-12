package ru.portal.onlearn.Validation.Validators;

import org.springframework.stereotype.Component;
import ru.portal.onlearn.Validation.ContactLoginNullOrSizeConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ContactLoginNullOrSizeValidator implements ConstraintValidator<ContactLoginNullOrSizeConstraint, String> {

    @Override
    public void initialize(ContactLoginNullOrSizeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return login != null && login.matches("[a-zA-Z-_\\.]*")
                && (login.length() > 3) && (login.length() < 26);
    }
}
