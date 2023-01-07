package pe.mil.microservices.utils.components.enums;

import com.google.common.collect.Lists;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public enum GroupResponseCode {
    INVALID_PARAMETER_ID_NUMBER_VALUE_IS_INVALID("001", "The ID number value is invalid", Lists.newArrayList("396", "400"));

    GroupResponseCode(String responseCodeValue, String responseCodeMessage, List<String> responseCodeGroup) {
        this.responseCodeValue = responseCodeValue;
        this.responseCodeMessage = responseCodeMessage;
        this.responseCodeGroup = responseCodeGroup;
    }

    private static final Map<String, GroupResponseCode> MAP_GROUP_RESPONSE_CODE = new HashMap<>();

    static {
        for (final GroupResponseCode grc : EnumSet.allOf(GroupResponseCode.class)) {
            MAP_GROUP_RESPONSE_CODE.put(grc.getResponseCodeMessage(), grc);
        }
    }

    public static GroupResponseCode findGroupResponseCode(final String responseCodeValue) {
        return StringUtils.isNoneBlank(responseCodeValue) ? MAP_GROUP_RESPONSE_CODE.get(responseCodeValue) : null;
    }

    final String responseCodeValue;
    final String responseCodeMessage;
    final List<String> responseCodeGroup;

}
