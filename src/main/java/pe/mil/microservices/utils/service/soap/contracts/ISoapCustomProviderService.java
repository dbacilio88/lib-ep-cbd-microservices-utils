package pe.mil.microservices.utils.service.soap.contracts;

import pe.mil.microservices.utils.dtos.request.SoapBusinessRequest;
import pe.mil.microservices.utils.dtos.responses.SoapBusinessResponse;
import pe.mil.microservices.utils.service.soap.abstractions.contracts.ISoapCustomDefinition;
import reactor.core.publisher.Mono;

public interface ISoapCustomProviderService {

    <T, R> Mono<SoapBusinessResponse<R>> doOnExecuteSoapService(SoapBusinessRequest<T, R> soapBusinessRequest, ISoapCustomDefinition soapCustomDefinition);
}
