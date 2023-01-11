package pe.mil.microservices.utils.components.interceptors;

import lombok.experimental.UtilityClass;
import org.springframework.http.server.PathContainer;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.pattern.PathPatternParser;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import static pe.mil.microservices.utils.constants.CommonReactiveProcessConstants.*;

@UtilityClass
public class CommonInterceptorHelper {

    public final static Function<ServerWebExchange, Boolean> validateActuator = serverWebExchange -> {

        if (Objects.isNull(serverWebExchange)) {
            return false;
        }
        return serverWebExchange
            .getRequest()
            .getURI()
            .getPath()
            .contains(PARAMETER_ACTUATOR_PATH_CONTAIN_VALUE);
    };

    public final static Function<ServerWebExchange, Boolean> validateCommonHealthEndpoints = serverWebExchange -> {

        if (Objects.isNull(serverWebExchange)) {

            return false;
        }

        final PathContainer pathContainer = PathContainer
            .parsePath(
                serverWebExchange
                    .getRequest()
                    .getPath()
                    .pathWithinApplication()
                    .value()
            );

        return new PathPatternParser().parse(MICROSERVICE_COMMON_PATH_ACTUATOR_VALUE).matches(pathContainer) ||
            new PathPatternParser().parse(MICROSERVICE_COMMON_PATH_POD_INFO_VALUE).matches(pathContainer) ||
            new PathPatternParser().parse(MICROSERVICE_COMMON_PATH_SWAGGER_RESOURCES_VALUE).matches(pathContainer) ||
            new PathPatternParser().parse(MICROSERVICE_COMMON_PATH_SWAGGER_UI_VALUE).matches(pathContainer) ||
            new PathPatternParser().parse(MICROSERVICE_COMMON_PATH_SWAGGER_V2_API_DOCS_VALUE).matches(pathContainer) ||
            new PathPatternParser().parse(MICROSERVICE_COMMON_PATH_SWAGGER_V3_API_DOCS_VALUE).matches(pathContainer);

    };

    public static String generateRequestId() {
        return String.format(
            MICROSERVICE_COMMON_REQUEST_AUTO_GENERATE_FORMAT_VALUE,
            MICROSERVICE_COMMON_REQUEST_AUTO_GENERATE_VALUE,
            UUID.randomUUID()
        ).toUpperCase(Locale.getDefault());
    }
}