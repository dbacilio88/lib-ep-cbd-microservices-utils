package pe.mil.microservices.utils.components.decorator;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.ThreadContext;
import org.reactivestreams.Publisher;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import pe.mil.microservices.utils.constants.CommonReactiveLoggerConstants;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;

@Log4j2
public class MicroserviceCommonHttpResponseDecorator extends ServerHttpResponseDecorator {
    private final DataBufferFactory bufferFactory;

    public MicroserviceCommonHttpResponseDecorator(ServerHttpResponse delegate) {
        super(delegate);
        this.bufferFactory = super.bufferFactory();
    }

    @Override
    public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {

        super.getHeaders()
            .add(
                CommonReactiveLoggerConstants.HEADER_REQUEST_ID, ThreadContext.get(CommonReactiveLoggerConstants.KEY_REQUEST_ID)
            );

        if (body instanceof Flux) {
            return super.writeWith(
                Flux.from(body)
                    .map(dataBuffer -> this.bufferFactory.wrap(contentRaw(dataBuffer, body)))
            );
        }

        if (body instanceof Mono) {
            return super.writeWith(
                Mono.from(body)
                    .map(dataBuffer -> this.bufferFactory.wrap(contentRaw(dataBuffer, body)))
            );
        }

        log.info(CommonReactiveLoggerConstants.HTTP_RESPONSE_FORMAT, body, super.getHeaders().getFirst(HttpHeaders.LOCATION), super.getStatusCode());
        return super.writeWith(body);
    }

    private byte[] contentRaw(DataBuffer dataBuffer, Publisher<? extends DataBuffer> body) {
        final byte[] content = new byte[dataBuffer.readableByteCount()];
        dataBuffer.read(content);
        final String contentRaw = new String(content, StandardCharsets.UTF_8);
        log.info(CommonReactiveLoggerConstants.REQUEST_HEADERS_MESSAGE, super.getHeaders());
        log.info(CommonReactiveLoggerConstants.HTTP_RESPONSE_FORMAT,
            body,
            super
                .getHeaders()
                .getFirst(HttpHeaders.LOCATION),
            super.getStatusCode());
        log.info(CommonReactiveLoggerConstants.RESPONSE_MESSAGE, contentRaw);
        return contentRaw.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
        log.info(CommonReactiveLoggerConstants.HTTP_WRITE_AND_FLUSH_WITH_FORMAT, super.getStatusCode());
        return super.writeAndFlushWith(body);
    }
}