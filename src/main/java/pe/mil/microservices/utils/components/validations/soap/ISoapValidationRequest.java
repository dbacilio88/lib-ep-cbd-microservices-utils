package pe.mil.microservices.utils.components.validations.soap;

import pe.mil.microservices.utils.dtos.wsdl.SoapValidationResult;

public interface ISoapValidationRequest<T> {

    SoapValidationResult validateRequest(T request);

}
