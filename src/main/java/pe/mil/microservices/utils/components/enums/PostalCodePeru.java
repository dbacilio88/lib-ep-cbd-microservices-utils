package pe.mil.microservices.utils.components.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Getter
public enum PostalCodePeru {

    AMAZONAS("01", "Departamento de Amazonas"),
    ANCASH("02", "Departamento de Áncash"),
    APURIMAC("03", "Departamento de Apurímac"),
    AREQUIPA("04", "Departamento de Arequipa"),
    AYACUCHO("05", "Departamento de Ayacucho"),
    CAJAMARCA("06", "Departamento de Cajamarca"),
    CALLAO("07", "Callao"),
    CUZCO("08", "Departamento de Cuzco"),
    HUANCAVELICA("09", "Departamento de Huancavelica"),
    HUANUCO("10", "Departamento de Huánuco"),
    ICA("11", "Departamento de Ica"),
    JUNIN("12", "Departamento de Junín"),
    LA_LIBERTAD("13", "Departamento de La Libertad"),
    LAMBAYEQUE("14", "Departamento de Lambayeque"),
    LIMA("15", "Departamento de Lima"),
    LORETO("16", "Departamento de Loreto"),
    MADRE_DE_DIOS("17", "Departamento de Madre de Dios"),
    MOQUEGUA("18", "Departamento de Moquegua"),
    PASCO("19", "Departamento de Pasco"),
    PIURA("20", "Departamento de Piura"),
    PUNO("21", "Departamento de Puno"),
    SAN_MARTIN("22", "Departamento de San Martín"),
    TACNA("23", "Departamento de Tacna"),
    TUMBES("24", "Departamento de Tumbes"),
    UCAYALI("25", "Departamento de Ucayali"),
    ;
    private final String codeValue;
    private final String regionValue;
    private static final Map<String, PostalCodePeru> MAP_RESPONSE_POSTAL_CODE_PERU = new HashMap<>();

    PostalCodePeru(String code, String region) {
        this.codeValue = code;
        this.regionValue = region;
    }

    static {
        for (final PostalCodePeru pcp : EnumSet.allOf(PostalCodePeru.class)) {
            MAP_RESPONSE_POSTAL_CODE_PERU.put(pcp.getCodeValue(), pcp);
        }
    }

    @Override
    public String toString() {
        return "PostalCodePeru{" +
            "codeValue='" + codeValue + '\'' +
            ", regionValue='" + regionValue + '\'' +
            '}';
    }

    public static PostalCodePeru findResponseCode(final String code) {
        return StringUtils.isNoneBlank(code) ? MAP_RESPONSE_POSTAL_CODE_PERU.get(code.toUpperCase(Locale.US)) : null;
    }

    public static boolean exists(final String code) {
        return StringUtils.isNoneBlank(code) && MAP_RESPONSE_POSTAL_CODE_PERU.containsKey(code.toUpperCase(Locale.US));
    }
}
