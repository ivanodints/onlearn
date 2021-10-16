package ru.portal.onlearn.Validation.Validators;

import ru.portal.onlearn.Validation.ContactEmailConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactEmailValidator implements ConstraintValidator<ContactEmailConstraint, String> {

    @Override
    public void initialize(ContactEmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email != null && email.matches(
                "[^\\s][\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
    }
}


