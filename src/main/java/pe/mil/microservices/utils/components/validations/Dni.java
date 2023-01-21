package pe.mil.microservices.utils.components.validations;

import pe.mil.microservices.utils.constants.ValidationConstants;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = DniValidation.class)
@Documented
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Dni {

    String message() default ValidationConstants.REGEX_DOCUMENT_NUMBER_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
