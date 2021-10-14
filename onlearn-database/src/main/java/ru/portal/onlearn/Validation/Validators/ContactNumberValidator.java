package ru.portal.onlearn.Validation.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import ru.portal.onlearn.Validation.ContactNumberConstraint;
import ru.portal.onlearn.repo.EmployeeRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void initialize(ContactNumberConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext cxt) {
        return phone.matches("[^\\s][0-9+\\.]*")
                && (phone.length() > 11) && (phone.length() < 13)
                && !employeeRepository.existsEmployeeByPhoneNumber(phone);
    }

}
