package pe.mil.microservices.utils.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonReactiveLoggerConstants {

    public static final String HEADER_USER_ID = "X-User-id";
    public static final String HEADER_REQUEST_ID = "X-Request-id";
    public static final String HEADER_TENANT_ID = "X-Tenant-Id";

    public static final String KEY_USER_ID = "userId";
    public static final String KEY_REQUEST_ID = "requestId";
    public static final String KEY_TENANT_ID = "tenantId";
    public static final String CONSTANTS_LOG_METHOD = "method";
    public static final String REQUEST_MESSAGE = "Request: {}";
    public static final String RESPONSE_MESSAGE = "Response: {}";
    public static final String REQUEST_PATH_VARIABLES_MESSAGE = "PathVariables: {}";
    public static final String REQUEST_QUERY_PARAMS_MESSAGE = "QueryParams: {}";
    public static final String REQUEST_HEADERS_MESSAGE = "Headers: {}";
    public static final String EXTERNAL_PATH_VARIABLES_MESSAGE = "ExternalPathVariables: {}";
    public static final String EXTERNAL_QUERY_PARAMS_MESSAGE = "ExternalQueryParams: {}";
    public static final String EXTERNAL_HEADERS_MESSAGE = "ExternalHeaders: {}";
    public static final String EXTERNAL_URI_MESSAGE = "ExternalUri: {}";
    public static final String EXTERNAL_REQUEST_MESSAGE = "ExternalRequest: {}";
    public static final String EXTERNAL_RESPONSE_MESSAGE = "ExternalResponse: {}";
    public static final String LOG_LEVEL = "log.level";

    public static final String HTTP_RESPONSE_FORMAT = "Response type [{}] from URL [{}] with state code [{}]";
    public static final String HTTP_WRITE_AND_FLUSH_WITH_FORMAT = "Response with state code[{}]";
}
