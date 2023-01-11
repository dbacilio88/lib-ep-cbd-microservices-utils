package pe.mil.microservices.utils.components.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import pe.mil.microservices.utils.components.enums.ResponseCode;
import pe.mil.microservices.utils.dtos.process.BusinessProcessResponse;
import reactor.core.publisher.Mono;

@Log4j2
@Component
public class CommonBusinessProcessHandler {

    public Mono<BusinessProcessResponse> processErrorHandler(Throwable throwable) {
        log.error("error in business response process {}", throwable.getMessage());
        return Mono.just(BusinessProcessResponse.setBusinessProcessError(ResponseCode.INTERNAL_SERVER_ERROR));
    }

    public Mono<BusinessProcessResponse> processErrorHandler(Throwable throwable, ResponseCode responseCode) {
        log.error("error in business response process {}", throwable.getMessage());
        return Mono.just(BusinessProcessResponse.setBusinessProcessError(responseCode));
    }
}
