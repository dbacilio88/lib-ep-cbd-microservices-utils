package pe.mil.microservices.utils.constants;

import lombok.experimental.UtilityClass;
@UtilityClass
public class BaseBeanScopesConstants {
    public static final String BEAN_SCOPE_SINGLETON = "singleton";
    public static final String BEAN_SCOPE_PROTOTYPE = "prototype";
    public static final String WEB_APPLICATION_CONTEXT_SCOPE_REQUEST = "request";
    public static final String WEB_APPLICATION_CONTEXT_SCOPE_SESSION = "session";
    public static final String WEB_APPLICATION_CONTEXT_SCOPE_APPLICATION = "application";
}