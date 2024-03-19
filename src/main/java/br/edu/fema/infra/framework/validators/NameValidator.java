package br.edu.fema.infra.framework.validators;

import br.edu.fema.infra.framework.annotations.NameValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import java.util.Objects;

public class NameValidator implements ConstraintValidator<NameValidation, String> {

    private int parts;

    @Override
    public void initialize(NameValidation constraintAnnotation) {
        this.parts = constraintAnnotation.parts();
    }


    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (Objects.isNull(name)) {
            return true;
        }
        // if name = "guilherme farto" entao parts = ["guilherme", "farto"]
        //split cria array
        final String[] parts = name.trim().split(" ");

        final boolean validated = parts.length >= this.parts;

        if (!validated) {
            ((ConstraintValidatorContextImpl) context)
                    .addMessageParameter("number_parts", this.parts)
                    .addMessageParameter("name", name);

            ((ConstraintValidatorContextImpl) context)
                    .buildConstraintViolationWithTemplate("Critical: Nome inválido")
                    .addConstraintViolation();
        }

        return validated;
    }
}
