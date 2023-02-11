package pe.mil.microservices.utils.components.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import pe.mil.microservices.utils.components.configuration.MicroservicesErrorHandlerConfiguration;
import pe.mil.microservices.utils.components.enums.ResponseCode;
import pe.mil.microservices.utils.dtos.base.BaseBusinessErrorResponse;
import pe.mil.microservices.utils.dtos.base.BusinessResponse;
import pe.mil.microservices.utils.dtos.errors.BaseErrorResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CommonGlobalExceptionHandler {

    private final MicroservicesErrorHandlerConfiguration microservicesErrorHandlerConfiguration;
    private final BusinessResponse businessResponse;

    public CommonGlobalExceptionHandler(
        final MicroservicesErrorHandlerConfiguration microservicesErrorHandlerConfiguration,
        final BusinessResponse businessResponse
    ) {
        this.microservicesErrorHandlerConfiguration = microservicesErrorHandlerConfiguration;
        this.businessResponse = businessResponse;
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(final Exception ex) {
        log.trace("Execute handle all exception", ex);
        return businessResponse
            .getResponse(
                BaseBusinessErrorResponse
                    .builder()
                    .data(
                        BaseErrorResponse
                            .builder()
                            .info(
                                microservicesErrorHandlerConfiguration.isHandlerInformationEnable()
                                    ? microservicesErrorHandlerConfiguration.getLink()
                                    : null
                            )
                            /**
                             * Jdk: 8
                             .errors(Stream.of(new BaseErrorResponse.ErrorResponse(ex.getMessage())).collect(Collectors.toList()))
                             .errors(Arrays.asList(new BaseErrorResponse.ErrorResponse(ex.getMessage())))
                             */
                            .errors(
                                List
                                    .of(new BaseErrorResponse.ErrorResponse(ex.getMessage()))
                            )
                            .build()
                    ).build(),
                ResponseCode.ERROR_PARAMETERS_INVALID.getResponseCodeValue(), getHeadersByHandler()
            );
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleConflict(final RuntimeException ex) {
        log.trace("Execute handle MethodArgumentTypeMismatchException", ex);
        return businessResponse
            .getResponse(
                BaseBusinessErrorResponse
                    .builder()
                    .data(
                        BaseErrorResponse
                            .builder()
                            .info(
                                microservicesErrorHandlerConfiguration.isHandlerInformationEnable()
                                    ? microservicesErrorHandlerConfiguration.getLink()
                                    : null
                            )
                            /**
                             * Jdk: 8
                             .errors(Stream.of(new BaseErrorResponse.ErrorResponse(ex.getMessage())).collect(Collectors.toList()))
                             .errors(Arrays.asList(new BaseErrorResponse.ErrorResponse(ex.getMessage())))
                             */
                            .errors(
                                List
                                    .of(new BaseErrorResponse.ErrorResponse(ex.getLocalizedMessage()))
                            ).build()
                    )
                    .build(),
                ResponseCode.ERROR_INTEGRATION_ERROR.getResponseCodeValue(),
                getHeadersByHandler()

            );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex) {
        log.error("Execute handle MethodArgumentNotValidException", ex);
        final Map<String, Object> body = new HashMap<>();
        body.put("error", ex);
        return new ResponseEntity<>(body, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Object> handleException(final WebExchangeBindException e) {
        log.trace("Execute handle WebExchangeBindException", e);

        return businessResponse
            .getResponse(
                BaseBusinessErrorResponse
                    .builder()
                    .data(
                        BaseErrorResponse.
                            builder()
                            .info(
                                microservicesErrorHandlerConfiguration.isHandlerInformationEnable()
                                    ? microservicesErrorHandlerConfiguration.getLink()
                                    : null)
                            .errors(e
                                .getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(fieldError -> new BaseErrorResponse
                                    .ErrorResponse(String.format("Field %s: %s", fieldError.getField(), fieldError.getDefaultMessage())))
                                .collect(Collectors.toList()))
                            .build()
                    ).build(),
                ResponseCode.ERROR_PARAMETERS_INVALID.getResponseCodeValue(),
                getHeadersByHandler()
            );
    }

    private HttpHeaders getHeadersByHandler() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
