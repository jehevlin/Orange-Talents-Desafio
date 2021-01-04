package com.jessica.onboarding.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {IdadeMinimaValidator.class})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface IdadeMinima {

    String message() default "Idade inválida";

    int idade() default 16;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
