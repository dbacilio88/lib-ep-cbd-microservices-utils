package pe.mil.microservices.utils.components.interceptors;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import pe.mil.microservices.utils.components.context.ContextHolderRequestReactive;
import pe.mil.microservices.utils.components.decorator.MicroserviceCommonHttpRequestDecorator;
import pe.mil.microservices.utils.components.decorator.MicroserviceCommonHttpResponseDecorator;
import pe.mil.microservices.utils.constants.BaseInterceptorConstants;
import pe.mil.microservices.utils.constants.LoggerConstants;
import pe.mil.microservices.utils.constants.ProcessConstants;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class AppLoggerInterceptor implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        if (CommonInterceptorHelper.validateCommonHealthEndpoints.apply(exchange)) {
            return chain.filter(exchange.mutate().build());
        }

        exchange.getRequest().mutate().headers(h -> {
            log.info("AppLoggerInterceptor {} ", h);
        });

        final String userId = StringUtils
            .defaultIfEmpty(
                exchange
                    .getRequest()
                    .getHeaders()
                    .getFirst(BaseInterceptorConstants.HEADER_USER_ID),
                ProcessConstants.PARAMETER_EMPTY_VALUE
            );

        final String tenantId = StringUtils
            .defaultIfEmpty(
                exchange
                    .getRequest()
                    .getHeaders()
                    .getFirst(BaseInterceptorConstants.HEADER_TENANT_ID),
                ProcessConstants.PARAMETER_EMPTY_VALUE
            );

        final String requestId = StringUtils
            .defaultIfEmpty(
                exchange
                    .getRequest()
                    .getHeaders()
                    .getFirst(BaseInterceptorConstants.HEADER_REQUEST_ID),
                ProcessConstants.PARAMETER_EMPTY_VALUE
            );

        ThreadContext.put(LoggerConstants.KEY_USER_ID, userId);
        ThreadContext.put(LoggerConstants.KEY_TENANT_ID, tenantId);
        ThreadContext.put(LoggerConstants.KEY_REQUEST_ID, requestId);
        return chain
            .filter(
                exchange
                    .mutate()
                    .request(new MicroserviceCommonHttpRequestDecorator(exchange.getRequest()))
                    .response(new MicroserviceCommonHttpResponseDecorator(exchange.getResponse()))
                    .build()
            )
            .contextWrite(context ->
                context
                    .put(ContextHolderRequestReactive.CONTEXT_KEY, exchange.getRequest()));
    }
}