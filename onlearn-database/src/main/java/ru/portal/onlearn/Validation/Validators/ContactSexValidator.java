package ru.portal.onlearn.Validation.Validators;

import ru.portal.onlearn.Validation.ContactSexConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactSexValidator implements ConstraintValidator<ContactSexConstraint, String> {

    @Override
    public void initialize(ContactSexConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String sex, ConstraintValidatorContext constraintValidatorContext) {
        return sex.matches("[а-яА-Яa-zA-Z-_\\.]*")
                && (sex.length() > 2) && (sex.length() < 8);
    }
}
