package pe.mil.microservices.utils.components.factories.soap.contracts;

import pe.mil.microservices.utils.service.soap.abstractions.contracts.ISoapCustomDefinition;

public interface ISoapCustomDefinitionFactory {

    ISoapCustomDefinition factory(String customDefinitionId);
}
