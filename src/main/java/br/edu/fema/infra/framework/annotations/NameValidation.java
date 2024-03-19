package br.edu.fema.infra.framework.annotations;

import br.edu.fema.infra.framework.validators.MateriaValidator;
import br.edu.fema.infra.framework.validators.NameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
@Documented
public @interface NameValidation {

    String message() default "Curso deve possuir ao menos {number_parts} materias";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int parts() default 2;
}
