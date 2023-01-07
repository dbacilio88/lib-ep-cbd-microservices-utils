package pe.mil.microservices.utils.components.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component(value = "properties")
@ConfigurationProperties()
public class MicroserviceProperties {

    @Value("${spring.application.name:component name not available}")
    private String name;

    @Value("${server.port:8080}")
    private String port;

    @Value("${server.servlet.context-path:component-server-servlet-context-path-not-available}")
    private String contextPath;

    @Value("${spring.webflux.base-path:component-spring-webflux-base-path-not-available}")
    private String webFluxContextPath;

    @Value("${spring.version:component version not available}")
    private String version;

    @Value("${spring.application.version:component version not available}")
    private String application;
}
