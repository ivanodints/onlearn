package ru.portal.onlearn.Validation.Validators;

import ru.portal.onlearn.Validation.ContactPasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactPasswordValidator implements ConstraintValidator<ContactPasswordConstraint, String> {
    @Override
    public void initialize(ContactPasswordConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password.matches("[^\\s][а-яА-Яa-zA-Z-0-9~`@!#$%^&*={}_<>/?,()-+\\.]*")
                && (password.length() > 6);
    }
}
