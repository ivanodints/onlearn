package ru.portal.onlearn.Validation.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.portal.onlearn.Validation.ContactLoginConstraint;
import ru.portal.onlearn.repo.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ContactLoginValidator implements ConstraintValidator<ContactLoginConstraint, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public void initialize(ContactLoginConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String login, ConstraintValidatorContext constraintValidatorContext) {

        return !userRepository.existsUserByLogin(login);

    }
}
