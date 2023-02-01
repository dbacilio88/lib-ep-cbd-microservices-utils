package pe.mil.microservices.utils.service.soap.abstractions.contracts;

import pe.mil.microservices.utils.components.validations.soap.ISoapValidationRequest;
import pe.mil.microservices.utils.components.validations.soap.ISoapValidationResponse;
import pe.mil.microservices.utils.dtos.request.SoapClientRequest;

public interface ISoapStandardDefinition {

    <ST> ISoapValidationRequest<ST> validateSoapRequest();

    <SR> ISoapValidationResponse<SR> validateSoapResponse();

    <ST> SoapClientRequest<ST> buildNovoSoapClientRequest(ST soapRequest);
}
