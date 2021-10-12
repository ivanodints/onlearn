package ru.portal.onlearn.Validation.Validators;

import ru.portal.onlearn.Validation.ContactNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

    @Override
    public void initialize(ContactNumberConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {
         if (contactField == null){
             return false;
         }
        return contactField.matches("[0-9()-+\\.]*")
                && (contactField.length() > 8) && (contactField.length() < 18);
    }

}
