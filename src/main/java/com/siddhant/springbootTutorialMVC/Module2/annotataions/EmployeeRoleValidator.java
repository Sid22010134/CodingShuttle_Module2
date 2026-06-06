package com.siddhant.springbootTutorialMVC.Module2.annotataions;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> validRoles = Arrays.asList("ADMIN", "USER");
        return validRoles.contains(value);
    }
}
