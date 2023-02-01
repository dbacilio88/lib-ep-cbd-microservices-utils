package pe.mil.microservices.utils.components.factories.soap.implementations;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;
import pe.mil.microservices.utils.components.enums.ResponseCode;
import pe.mil.microservices.utils.components.exceptions.SoapProcessException;
import pe.mil.microservices.utils.components.factories.soap.contracts.ISoapStandardDefinitionFactory;
import pe.mil.microservices.utils.service.soap.abstractions.contracts.ISoapStandardDefinition;

@Log4j2
@Component
public class SoapStandardDefinitionFactory implements ISoapStandardDefinitionFactory {
    private final BeanFactory beanFactory;

    public SoapStandardDefinitionFactory(final BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public ISoapStandardDefinition factory(String customDefinitionId) {
        try {
            log.debug("customDefinitionId: {}", customDefinitionId);
            return beanFactory.getBean(customDefinitionId, ISoapStandardDefinition.class);
        } catch (BeansException e) {
            log.error("error in process factory ISoapStandardDefinition, error: {}", e.getMessage());
            throw new SoapProcessException("error in SoapStandardDefinitionFactory, error in factory process", ResponseCode.INTERNAL_SERVER_ERROR);
        }
    }
}
