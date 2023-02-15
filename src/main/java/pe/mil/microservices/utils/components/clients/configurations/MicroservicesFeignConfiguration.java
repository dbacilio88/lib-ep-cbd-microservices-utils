package pe.mil.microservices.utils.components.clients.configurations;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@Configuration
@EnableReactiveFeignClients(basePackages = {"pe.mil.microservices"})
@EnableFeignClients(basePackages = {"pe.mil.microservices"})
public class MicroservicesFeignConfiguration {
}
