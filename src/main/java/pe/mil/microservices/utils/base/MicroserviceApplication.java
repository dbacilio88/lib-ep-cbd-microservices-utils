package pe.mil.microservices.utils.base;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import pe.mil.microservices.utils.components.properties.MicroserviceProperties;
import java.util.Objects;
import static pe.mil.microservices.utils.constants.BaseParametersInvalidConstants.COMPONENT_SERVER_SERVLET_CONTEXT_PATH;
import static pe.mil.microservices.utils.constants.BaseParametersInvalidConstants.MICROSERVICES_CONTEXT_NOT_FOUND_MESSAGE;

@Configuration
@EnableConfigurationProperties(MicroserviceProperties.class)
@EnableAutoConfiguration
public abstract class MicroserviceApplication implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LogManager.getLogger(MicroserviceApplication.class);
    private final MicroserviceProperties microserviceProperties;

    public MicroserviceApplication(MicroserviceProperties microserviceProperties) {
        this.microserviceProperties = microserviceProperties;
    }

    @Override
    public void onApplicationEvent( ContextRefreshedEvent event) {
        logger.info("************************ MICROSERVICE APP ************************************");
        logger.info("Spring Version: {}", this.microserviceProperties.getApplication());
        logger.info("Name: {}", this.microserviceProperties.getName());
        logger.info("Version: {}", this.microserviceProperties.getVersion());
        logger.info("Context: {}", this.findMicroservicesContext());
        logger.info("Port: {}", this.microserviceProperties.getPort());
        logger.info("Microservice load success.");
        logger.info("************************ MICROSERVICE APP ************************************");
    }

    private String findMicroservicesContext() {
        if (
            Objects.nonNull(this.microserviceProperties.getContextPath())
                && StringUtils.isNoneEmpty(this.microserviceProperties.getContextPath())
                && !COMPONENT_SERVER_SERVLET_CONTEXT_PATH.equals(this.microserviceProperties.getContextPath())
        ) {
            return this.microserviceProperties.getContextPath();

        }

        if (
            Objects.nonNull(this.microserviceProperties.getWebFluxContextPath())
                && StringUtils.isNoneEmpty(this.microserviceProperties.getWebFluxContextPath())
                && !COMPONENT_SERVER_SERVLET_CONTEXT_PATH.equals(this.microserviceProperties.getWebFluxContextPath())
        ) {
            return this.microserviceProperties.getWebFluxContextPath();

        }

        return MICROSERVICES_CONTEXT_NOT_FOUND_MESSAGE;
    }
}
