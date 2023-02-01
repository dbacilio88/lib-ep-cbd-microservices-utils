package pe.mil.microservices.utils.components.validations.soap;

import pe.mil.microservices.utils.dtos.wsdl.SoapValidationResult;

public interface ISoapValidationResponse<T> {

    SoapValidationResult validateResponse(T response);
}
