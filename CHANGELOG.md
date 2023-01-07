# Changelog

`Todos los cambios notables en este proyecto se documentarán en este archivo.`
`El formato se basa en [Mantener un registro de cambios] (https://keepachangelog.com/en/1.0.0/),
y este proyecto se adhiere a [Semantic Versioning] (https://semver.org/spec/v2.0.0.html).`

## [1.0.0] - 2023-01-03

### Create project

- Initial project **microservicio utils** for **Centro de Informática del
  Ejército**. [@dbacilio88](https://github.com/dbacilio88)

### Items

- **Add** components enum
    * GroupResponseCode
    * LanguageCode
    * ResponseCode

- **Add** components helper
    * ContextCurrentTimeHelper
    * ContextInformationService
    * DataMessageTransformJson

- **Add** components interceptor
    * MetricsLoggerInterceptor

- **Add** components properties
    * MicroserviceProperties

- **Add** base microservice information
    * MicroserviceApplication

- **Add** constants
    * BaseInterceptorConstants
    * BaseParametersInvalidConstants

- **Add** dto
    * ***base*** BaseBusinessErrorResponse
    * ***base*** BaseBusinessResponseDto
    * ***base*** BusinessResponse
    * ***base*** GenericMessagesBusinessResponse
    * ***errors*** BaseErrorDetailResponse
    * ***errors*** BaseErrorResponse
    * ***messages*** MessageBusinessResponse
    * ***messages*** MessageResponseDto