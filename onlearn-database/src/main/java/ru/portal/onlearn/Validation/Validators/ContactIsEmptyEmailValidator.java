package ru.portal.onlearn.Validation.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.portal.onlearn.Validation.ContactIsEmptyEmailConstraint;
import ru.portal.onlearn.repo.EmployeeRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ContactIsEmptyEmailValidator implements ConstraintValidator<ContactIsEmptyEmailConstraint, String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void initialize(ContactIsEmptyEmailConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !employeeRepository.existsEmployeeByEmail(email);
    }
}
