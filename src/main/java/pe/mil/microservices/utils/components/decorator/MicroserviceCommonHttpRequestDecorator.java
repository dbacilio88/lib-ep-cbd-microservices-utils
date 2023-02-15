package pe.mil.microservices.utils.components.decorator;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import reactor.core.publisher.Flux;
@Log4j2
public class MicroserviceCommonHttpRequestDecorator extends ServerHttpRequestDecorator {
    public MicroserviceCommonHttpRequestDecorator(ServerHttpRequest delegate) {
        super(delegate);
    }

    @Override
    public Flux<DataBuffer> getBody() {
        log.info("Request from [{}]", super.getPath());
        return super.getBody();
    }
}
