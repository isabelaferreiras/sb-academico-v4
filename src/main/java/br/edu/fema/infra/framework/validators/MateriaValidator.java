package br.edu.fema.infra.framework.validators;

import br.edu.fema.infra.framework.annotations.MateriaValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import java.util.List;
import java.util.Objects;

public class MateriaValidator implements ConstraintValidator<MateriaValidation, List<String>> {

    private int parts;

    @Override
    public void initialize(MateriaValidation constraintAnnotation) {
        this.parts = constraintAnnotation.parts();
    }

    @Override
    public boolean isValid(List<String> materias, ConstraintValidatorContext context) {
        if (Objects.isNull(materias)) {
            return true;
        }
        // if name = "guilherme farto" entao parts = ["guilherme", "farto"]
        //split cria array
        final int parts = materias.size();
        final boolean validated = parts >= this.parts;

        if (!validated) {
            ((ConstraintValidatorContextImpl) context)
                    .addMessageParameter("number_parts", this.parts)
                    .addMessageParameter("materias", materias);

            ((ConstraintValidatorContextImpl) context)
                    .buildConstraintViolationWithTemplate("Critical: Matéria inválida")
                    .addConstraintViolation();
        }

        return validated;
    }
}
