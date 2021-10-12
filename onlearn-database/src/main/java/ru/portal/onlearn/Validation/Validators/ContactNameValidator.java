package ru.portal.onlearn.Validation.Validators;

import ru.portal.onlearn.Validation.ContactNameConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNameValidator implements ConstraintValidator<ContactNameConstraint, String> {

    @Override
    public void initialize(ContactNameConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext constraintValidatorContext) {
        if (contactField == null){
            return false;
        }
        return contactField.matches("[а-яА-Яa-zA-Z-_\\.]*")
                && (contactField.length() > 3) && (contactField.length() < 26);
    }
}
