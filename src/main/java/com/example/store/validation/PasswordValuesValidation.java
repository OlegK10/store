package com.example.store.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValuesValidation implements ConstraintValidator<PasswordValues, String> {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    Pattern pattern = Pattern.compile(PASSWORD_PATTERN,Pattern.CASE_INSENSITIVE);

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
