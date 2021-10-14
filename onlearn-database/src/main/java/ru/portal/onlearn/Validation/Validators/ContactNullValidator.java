package ru.portal.onlearn.Validation.Validators;

import ru.portal.onlearn.Validation.ContactNullConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNullValidator implements ConstraintValidator<ContactNullConstraint, String> {
    @Override
    public void initialize(ContactNullConstraint contactNullConstraint) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext constraintValidatorContext) {
        return contactField != null;
    }
}
