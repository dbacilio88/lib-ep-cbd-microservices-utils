package pe.mil.microservices.utils.service.soap.abstractions.contracts;

import pe.mil.microservices.utils.components.mappers.soap.contracts.ISoapMapperRequest;
import pe.mil.microservices.utils.components.mappers.soap.contracts.ISoapMapperResponse;
import pe.mil.microservices.utils.components.validations.soap.ISoapValidationRequest;
import pe.mil.microservices.utils.components.validations.soap.ISoapValidationResponse;
import pe.mil.microservices.utils.dtos.request.SoapClientRequest;

public interface ISoapCustomDefinition {

    <BT, ST> ISoapMapperRequest<BT, ST> soapMapperRequest();

    <SR, BR> ISoapMapperResponse<SR, BR> soapMapperResponse();

    <ST> ISoapValidationRequest<ST> validateSoapRequest();

    <SR> ISoapValidationResponse<SR> validateSoapResponse();

    <ST> SoapClientRequest<ST> buildNovoSoapClientRequest(ST soapRequest);
}
