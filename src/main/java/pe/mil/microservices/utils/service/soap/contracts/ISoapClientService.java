package pe.mil.microservices.utils.service.soap.contracts;

import pe.mil.microservices.utils.dtos.request.SoapClientRequest;
import pe.mil.microservices.utils.dtos.responses.SoapClientResponse;
import reactor.core.publisher.Mono;

public interface ISoapClientService {

    <T, R> Mono<SoapClientResponse<R>> doOnExecuteSoapMessage(SoapClientRequest<T> soapClientRequest);

    <T, R> SoapClientResponse<R> executeSoapMessage(SoapClientRequest<T> soapClientRequest);
}
