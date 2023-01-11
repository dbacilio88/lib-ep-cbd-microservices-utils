package pe.mil.microservices.utils.constants;

import lombok.experimental.UtilityClass;
@UtilityClass
public class CommonReactiveProcessConstants {
    public static final String MICROSERVICE_COMMON_PATH_CONTEXT = "";
    public static final String MICROSERVICE_COMMON_POD_INFO_PATH = "/podInfo";
    public static final String MICROSERVICE_COMMON_DELETE_TENANT_ALL_CACHE_PATH = "cache";
    public static final String MICROSERVICE_COMMON_RE_SYNC_CONFIGURATIONS_PATH = "resync";
    public static final String PARAMETER_ACTUATOR_PATH_CONTAIN_VALUE = "actuator";
    public static final String MICROSERVICE_COMMON_REQUEST_AUTO_GENERATE_VALUE = "novo-";
    public static final String MICROSERVICE_COMMON_REQUEST_AUTO_GENERATE_FORMAT_VALUE = "%s%s";
    public static final String MICROSERVICE_COMMON_PATH_ACTUATOR_VALUE = "/actuator/**";
    public static final String MICROSERVICE_COMMON_PATH_POD_INFO_VALUE = "/podInfo";
    public static final String MICROSERVICE_COMMON_PATH_SWAGGER_RESOURCES_VALUE = "/swagger-resources/**";
    public static final String MICROSERVICE_COMMON_PATH_SWAGGER_UI_VALUE = "/swagger-ui/**";
    public static final String MICROSERVICE_COMMON_PATH_SWAGGER_V2_API_DOCS_VALUE = "/v2/api-docs";
    public static final String MICROSERVICE_COMMON_PATH_SWAGGER_V3_API_DOCS_VALUE = "/v3/api-docs";
    public static final String MICROSERVICE_CONFIGURATION_PROCESS_DELETE_CACHE = "delete-configuration-cache";
    public static final String MICROSERVICE_CONFIGURATION_PROCESS_DELETE_CACHE_MESSAGE = "delete cache successfully completed";
    public static final String MICROSERVICE_CONFIGURATION_PROCESS_RE_SYNC = "re-sync-configuration";
    public static final String MICROSERVICE_CONFIGURATION_PROCESS_RE_SYNC_MESSAGE = "reSync configuration successfully completed";
    public static final String MICROSERVICE_CONFIGURATION_ERROR_HANDLER_LINK = "ERROR_HANDLER_LINK_NOT_DEFINED";
    public static final String MICROSERVICE_ERROR_HANDLER_LINK_EMPTY = "";
}