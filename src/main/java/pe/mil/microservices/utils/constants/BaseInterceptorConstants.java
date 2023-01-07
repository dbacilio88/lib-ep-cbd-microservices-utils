package pe.mil.microservices.utils.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BaseInterceptorConstants {

    public static final String HEADER_USER_ID = "X-User-Id";
    public static final String HEADER_REQUEST_ID = "X-Request-Id";
    public static final String HEADER_TENANT_ID = "X-Tenant-Id";
    public static final String HEADER_USER_ID_DESCRIPTION = "Unique identifier of the user";
    public static final String HEADER_REQUEST_ID_DESCRIPTION = "Unique identifier of the request";
    public static final String HEADER_TENANT_ID_EXAMPLE = "Unique identifier of the tenant";
    public static final String HEADER_USER_ID_EXAMPLE = "968b7ed5-1143-48bb-bc93-7fa866150942";
    public static final String HEADER_REQUEST_ID_EXAMPLE = "2e27e8d6-cdc8-48bf-8635-511a263ffaba";
    public static final String HEADER_TENANT_ID_DESCRIPTION = "e5f255b0-6941-48c7-a6f5-66099a5c5c3d";
    public static final String REQUEST_START_TIME = "request-start-time";
    public static final String REQUEST_END_TIME = "request-end-time";
    public static final String SESSION_CONTEXT_MESSAGE = "SESSION CONTEXT: {}";
    public static final String REQUEST_PATH_VARIABLES_MESSAGE = "PathVariables: {}";
    public static final String REQUEST_QUERY_PARAMS_MESSAGE = "QueryParams: {}";
    public static final String REQUEST_HEADERS_MESSAGE = "Headers: {}";
    public static final String REQUEST_MESSAGE = "Request: {}";
    public static final String RESPONSE_MESSAGE = "Response: {}";
    public static final String EXTERNAL_PATH_VARIABLES_MESSAGE = "ExternalPathVariables: {}";
    public static final String EXTERNAL_QUERY_PARAMS_MESSAGE = "ExternalQueryParams: {}";
    public static final String EXTERNAL_HEADERS_MESSAGE = "ExternalHeaders: {}";
    public static final String EXTERNAL_URI_MESSAGE = "ExternalUri: {}";
    public static final String EXTERNAL_REQUEST_MESSAGE = "ExternalRequest: {}";
    public static final String EXTERNAL_RESPONSE_MESSAGE = "ExternalResponse: {}";
    public static final String REQUEST_TIME_RESPONSE_MESSAGE = "Execute Time: {} milliseconds";
    public static final String EXCLUDE_PATH_PATTERNS_HEALTH_CHECK = "/healthcheck";
    public static final String EXCLUDE_PATH_PATTERNS_HEALTH_CHECK_TWO = "healthcheck";
    public static final int INTERCEPTOR_HIGHEST_PRECEDENCE = 1;
    public static final int INTERCEPTOR_LOWEST_PRECEDENCE = 2;
}
