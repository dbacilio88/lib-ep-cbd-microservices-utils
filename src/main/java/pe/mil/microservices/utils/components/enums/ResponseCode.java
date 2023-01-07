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
    ERROR_INVALID_PARAMETERS("396");

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
