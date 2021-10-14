package ru.portal.onlearn.Validation.Validators;

import org.springframework.stereotype.Component;
import ru.portal.onlearn.Validation.ContactLoginSizeConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ContactLoginSizeValidator implements ConstraintValidator<ContactLoginSizeConstraint, String> {

    @Override
    public void initialize(ContactLoginSizeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {
        return login != null && login.matches("[^\\s][a-zA-Z-_\\.]*")
                && (login.length() > 3) && (login.length() < 26);
    }
}
