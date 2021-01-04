
package com.jessica.onboarding.model.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class IdadeMinimaValidator implements ConstraintValidator<IdadeMinima, LocalDate> {
    private int idadeMinima;
    @Override
    public void initialize(IdadeMinima constraintAnnotation) {
        idadeMinima = constraintAnnotation.idade();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(date, dataAtual);
        return periodo.getYears() >= idadeMinima;
    }
}

