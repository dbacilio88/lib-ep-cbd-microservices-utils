package pe.mil.microservices.utils.components.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pe.mil.microservices.utils.dtos.commons.CommonApplicationInfo;

@Log4j2
@Configuration
@ComponentScan
public class MicroservicesCommonReactiveConfiguration {
    public MicroservicesCommonReactiveConfiguration() {
        log.debug("MicroservicesCommonReactiveConfiguration loaded successfully");
    }
    @Bean
    public CommonApplicationInfo commonApplicationInfo() {
        return new CommonApplicationInfo();
    }
}