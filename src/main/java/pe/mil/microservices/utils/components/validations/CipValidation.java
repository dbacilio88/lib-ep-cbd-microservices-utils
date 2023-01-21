package pe.mil.microservices.utils.components.validations;

import pe.mil.microservices.utils.components.helpers.NumberHelper;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CipValidation implements ConstraintValidator<Cip, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return NumberHelper.cipNumber(value);
    }

}
