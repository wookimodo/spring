package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// ConstraintValidator를 상속받아서 재사용가능하게 만듦.
public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private  String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // yyyyMM
        try{
            LocalDate localDate = LocalDate.parse(value + "01", DateTimeFormatter.ofPattern(this.pattern));
        }catch(Exception e){
            return false;
        }

        return true;
    }
}
