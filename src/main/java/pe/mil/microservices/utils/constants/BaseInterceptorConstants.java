package pe.mil.microservices.utils.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class BaseInterceptorConstants {

    public static final String HEADER_USER_ID = "X-User-Id";
    public static final String HEADER_REQUEST_ID = "X-Request-Id";
    public static final String REQUEST_START_TIME = "request-start-time";
    public static final String REQUEST_END_TIME = "request-end-time";
    public static final String REQUEST_TIME_RESPONSE_MESSAGE = "Execute Time: {} milliseconds";
}
