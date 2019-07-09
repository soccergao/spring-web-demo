package com.soccergao.springwebdemo.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 该类会交给spring管理
 * ConstraintValidator<PasswordCheck, String>中的String是字段的类型
 * 如: private String password 中的String;
 */
public class PasswordValidator implements ConstraintValidator<PasswordCheck, String> {

    private int value;

    @Override
    public void initialize(PasswordCheck constraintAnnotation) {
        value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() >= this.value;
    }
}
