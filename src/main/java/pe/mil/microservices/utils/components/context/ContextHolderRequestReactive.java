package pe.mil.microservices.utils.components.context;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;

@Log4j2
public class ContextHolderRequestReactive {

    public static final String CONTEXT_KEY = "request";

    public static Mono<ServerHttpRequest> getRequest() {
        return Mono
            .deferContextual(Mono::just)
            .map(ctx -> (ServerHttpRequest) ctx.get("request"));
    }

    public static Mono<AppSessionContext> getAppSessionContext() {
        return getRequest()
            .map(request -> AppSessionContext
                .builder()
                .applicationSession(
                    ApplicationSession
                        .builder()
                        .requestId(
                            request
                                .getHeaders()
                                .getFirst("X-Request-id")
                        )
                        .tenantId(
                            request
                                .getHeaders()
                                .getFirst("X-Tenant-Id")
                        )
                        .userId(
                            request
                                .getHeaders()
                                .getFirst("X-User-id")
                        ).build()
                )
                .build()
            )

            .onErrorContinue((ex, obj) -> log.error("Error getting AppSessionContext object from helper: {}", ex.getMessage()));
    }

    public static Mono<ApplicationSession> getAppSession() {
        return getRequest()
            .map(
                request -> ApplicationSession
                    .builder()
                    .requestId(
                        request
                            .getHeaders()
                            .getFirst("X-Request-id")
                    )
                    .tenantId(
                        request
                            .getHeaders()
                            .getFirst("X-Tenant-Id")
                    )
                    .userId(
                        request
                            .getHeaders()
                            .getFirst("X-User-id")
                    )
                    .build()
            )

            .onErrorContinue(
                (ex, obj) -> log.error("Error getting ApplicationSession object from helper: {}", ex.getMessage())
            );
    }
}
