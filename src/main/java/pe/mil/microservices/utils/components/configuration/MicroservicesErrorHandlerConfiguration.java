package pe.mil.microservices.utils.components.configuration;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static pe.mil.microservices.utils.constants.CommonReactiveProcessConstants.MICROSERVICE_CONFIGURATION_ERROR_HANDLER_LINK;

@Data
@Log4j2
@Configuration
@ConfigurationProperties(prefix = "microservice.error-handler")
public class MicroservicesErrorHandlerConfiguration {

    public MicroservicesErrorHandlerConfiguration() {
        log.debug("MicroservicesErrorHandlerConfiguration loaded successfully");
    }

    private String link;

    public Boolean isHandlerInformationEnable() {
        return !MICROSERVICE_CONFIGURATION_ERROR_HANDLER_LINK.equals(this.getLink());
    }
}