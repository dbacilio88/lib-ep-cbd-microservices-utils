package pe.mil.microservices.utils.components.factories.soap.contracts;

import pe.mil.microservices.utils.service.soap.abstractions.contracts.ISoapStandardDefinition;

public interface ISoapStandardDefinitionFactory {

    ISoapStandardDefinition factory(String customDefinitionId);
}
