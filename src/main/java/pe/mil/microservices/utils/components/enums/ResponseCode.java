package pe.mil.microservices.utils.components.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Getter
public enum ResponseCode {

    PROCESS_OK("000"),
    ERROR_PARAMETERS_INVALID("001"),
    ERROR_HEADERS_PARAMETER_REQUIRED("002"),
    ERROR_IN_REQUESTED_DATA("003"),
    ERROR_IN_REQUESTED_DATA_EXISTS("004"),
    SUCCESS_IN_REQUESTED_DATA_NOT_FOUND("005"),
    ERROR_DATA_INVALID("006"),
    ERROR_DATA_REGISTER_IN_DATABASE("007"),
    ERROR_INTEGRATION_ERROR("008"),
    INTERNAL_SERVER_ERROR("999");
    private final String responseCodeValue;

    private static final Map<String, ResponseCode> MAP_RESPONSE_CODE = new HashMap<>();

    ResponseCode(String responseCodeValue) {
        this.responseCodeValue = responseCodeValue;
    }

    static {
        for (final ResponseCode rc : EnumSet.allOf(ResponseCode.class)) {
            MAP_RESPONSE_CODE.put(rc.getResponseCodeValue(), rc);
        }
    }

    @Override
    public String toString() {
        return "ResponseCode{" + "responseCodeValue='" + responseCodeValue + '\'' + '}';
    }


    public static ResponseCode findResponseCode(final String code) {
        return StringUtils.isNoneBlank(code) ? MAP_RESPONSE_CODE.get(code.toUpperCase(Locale.US)) : null;
    }

    public static boolean exists(final String code) {
        return StringUtils.isNoneBlank(code) && MAP_RESPONSE_CODE.containsKey(code.toUpperCase(Locale.US));
    }
}
