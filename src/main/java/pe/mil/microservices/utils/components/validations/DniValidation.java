package pe.mil.microservices.utils.components.validations;

import pe.mil.microservices.utils.components.helpers.NumberHelper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DniValidation implements ConstraintValidator<Dni, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return NumberHelper.dniNumber(value);
    }

}
