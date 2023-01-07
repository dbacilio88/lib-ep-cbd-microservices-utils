package pe.mil.microservices.utils.components.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Getter
public enum LanguageCode {

    LANGUAGE_CODE_AB("Abkhazian", "AB"),
    LANGUAGE_CODE_AA("Afar", "AA"),
    LANGUAGE_CODE_AF("Afrikaans", "AF"),
    LANGUAGE_CODE_AK("Akan", "AK"),
    LANGUAGE_CODE_SQ("Albanian", "SQ"),
    LANGUAGE_CODE_AM("Amharic", "AM"),
    LANGUAGE_CODE_AR("Arabic", "AR"),
    LANGUAGE_CODE_AN("Aragonese", "AN"),
    LANGUAGE_CODE_HY("Armenian", "HY"),
    LANGUAGE_CODE_AS("Assamese", "AS"),
    LANGUAGE_CODE_AV("Avaric", "AV"),
    LANGUAGE_CODE_AE("Avestan", "AE"),
    LANGUAGE_CODE_AY("Aymara", "AY"),
    LANGUAGE_CODE_AZ("Azerbaijani", "AZ"),
    LANGUAGE_CODE_BM("Bambara", "BM"),
    LANGUAGE_CODE_BA("Bashkir", "BA"),
    LANGUAGE_CODE_EU("Basque", "EU"),
    LANGUAGE_CODE_BE("Belarusian", "BE"),
    LANGUAGE_CODE_BN("Bengali", "BN"),
    LANGUAGE_CODE_BI("Bislama", "BI"),
    LANGUAGE_CODE_BS("Bosnian", "BS"),
    LANGUAGE_CODE_BR("Breton", "BR"),
    LANGUAGE_CODE_BG("Bulgarian", "BG"),
    LANGUAGE_CODE_MY("Burmese", "MY"),
    LANGUAGE_CODE_CA("Catalan, Valencian", "CA"),
    LANGUAGE_CODE_CH("Chamorro", "CH"),
    LANGUAGE_CODE_CE("Chechen", "CE"),
    LANGUAGE_CODE_NY("Chichewa, Chewa, Nyanja", "NY"),
    LANGUAGE_CODE_ZH("Chinese", "ZH"),
    LANGUAGE_CODE_CV("Chuvash", "CV"),
    LANGUAGE_CODE_KW("Cornish", "KW"),
    LANGUAGE_CODE_CO("Corsican", "CO"),
    LANGUAGE_CODE_CR("Cree", "CR"),
    LANGUAGE_CODE_HR("Croatian", "HR"),
    LANGUAGE_CODE_CS("Czech", "CS"),
    LANGUAGE_CODE_DA("Danish", "DA"),
    LANGUAGE_CODE_DV("Divehi, Dhivehi, Maldivian", "DV"),
    LANGUAGE_CODE_NL("Dutch, Flemish", "NL"),
    LANGUAGE_CODE_DZ("Dzongkha", "DZ"),
    LANGUAGE_CODE_EN("English", "EN"),
    LANGUAGE_CODE_EO("Esperanto", "EO"),
    LANGUAGE_CODE_ET("Estonian", "ET"),
    LANGUAGE_CODE_EE("Ewe", "EE"),
    LANGUAGE_CODE_FO("Faroese", "FO"),
    LANGUAGE_CODE_FJ("Fijian", "FJ"),
    LANGUAGE_CODE_FI("Finnish", "FI"),
    LANGUAGE_CODE_FR("French", "FR"),
    LANGUAGE_CODE_FF("Fulah", "FF"),
    LANGUAGE_CODE_GL("Galician", "GL"),
    LANGUAGE_CODE_KA("Georgian", "KA"),
    LANGUAGE_CODE_DE("German", "DE"),
    LANGUAGE_CODE_EL("Greek, Modern (1453–)", "EL"),
    LANGUAGE_CODE_GN("Guarani", "GN"),
    LANGUAGE_CODE_GU("Gujarati", "GU"),
    LANGUAGE_CODE_HT("Haitian, Haitian Creole", "HT"),
    LANGUAGE_CODE_HA("Hausa", "HA"),
    LANGUAGE_CODE_HE("Hebrew", "HE"),
    LANGUAGE_CODE_HZ("Herero", "HZ"),
    LANGUAGE_CODE_HI("Hindi", "HI"),
    LANGUAGE_CODE_HO("Hiri Motu", "HO"),
    LANGUAGE_CODE_HU("Hungarian", "HU"),
    LANGUAGE_CODE_IA("International Auxiliary Language Association", "IA"),
    LANGUAGE_CODE_ID("Indonesian", "ID"),
    LANGUAGE_CODE_IE("Interlingue, Occidental", "IE"),
    LANGUAGE_CODE_GA("Irish", "GA"),
    LANGUAGE_CODE_IG("Igbo", "IG"),
    LANGUAGE_CODE_IK("Inupiaq", "IK"),
    LANGUAGE_CODE_IO("Ido", "IO"),
    LANGUAGE_CODE_IS("Icelandic", "IS"),
    LANGUAGE_CODE_IT("Italian", "IT"),
    LANGUAGE_CODE_IU("Inuktitut", "IU"),
    LANGUAGE_CODE_JA("Japanese", "JA"),
    LANGUAGE_CODE_JV("Javanese", "JV"),
    LANGUAGE_CODE_KL("Kalaallisut, Greenlandic", "KL"),
    LANGUAGE_CODE_KN("Kannada", "KN"),
    LANGUAGE_CODE_KR("Kanuri", "KR"),
    LANGUAGE_CODE_KS("Kashmiri", "KS"),
    LANGUAGE_CODE_KK("Kazakh", "KK"),
    LANGUAGE_CODE_KM("Central Khmer", "KM"),
    LANGUAGE_CODE_KI("Kikuyu, Gikuyu", "KI"),
    LANGUAGE_CODE_RW("Kinyarwanda", "RW"),
    LANGUAGE_CODE_KY("Kirghiz, Kyrgyz", "KY"),
    LANGUAGE_CODE_KV("Komi", "KV"),
    LANGUAGE_CODE_KG("Kongo", "KG"),
    LANGUAGE_CODE_KO("Korean", "KO"),
    LANGUAGE_CODE_KU("Kurdish", "KU"),
    LANGUAGE_CODE_KJ("Kuanyama, Kwanyama", "KJ"),
    LANGUAGE_CODE_LA("Latin", "LA"),
    LANGUAGE_CODE_LB("Luxembourgish, Letzeburgesch", "LB"),
    LANGUAGE_CODE_LG("Ganda", "LG"),
    LANGUAGE_CODE_LI("Limburgan, Limburger, Limburgish", "LI"),
    LANGUAGE_CODE_LN("Lingala", "LN"),
    LANGUAGE_CODE_LO("Lao", "LO"),
    LANGUAGE_CODE_LT("Lithuanian", "LT"),
    LANGUAGE_CODE_LU("Luba-Katanga", "LU"),
    LANGUAGE_CODE_LV("Latvian", "LV"),
    LANGUAGE_CODE_GV("Manx", "GV"),
    LANGUAGE_CODE_MK("Macedonian", "MK"),
    LANGUAGE_CODE_MG("Malagasy", "MG"),
    LANGUAGE_CODE_MS("Malay", "MS"),
    LANGUAGE_CODE_ML("Malayalam", "ML"),
    LANGUAGE_CODE_MT("Maltese", "MT"),
    LANGUAGE_CODE_MI("Maori", "MI"),
    LANGUAGE_CODE_MR("Marathi", "MR"),
    LANGUAGE_CODE_MH("Marshallese", "MH"),
    LANGUAGE_CODE_MN("Mongolian", "MN"),
    LANGUAGE_CODE_NA("Nauru", "NA"),
    LANGUAGE_CODE_NV("Navajo, Navaho", "NV"),
    LANGUAGE_CODE_ND("North Ndebele", "ND"),
    LANGUAGE_CODE_NE("Nepali", "NE"),
    LANGUAGE_CODE_NG("Ndonga", "NG"),
    LANGUAGE_CODE_NB("Norwegian Bokmål", "NB"),
    LANGUAGE_CODE_NN("Norwegian Nynorsk", "NN"),
    LANGUAGE_CODE_NO("Norwegian", "NO"),
    LANGUAGE_CODE_II("Sichuan Yi, Nuosu", "II"),
    LANGUAGE_CODE_NR("South Ndebele", "NR"),
    LANGUAGE_CODE_OC("Occitan", "OC"),
    LANGUAGE_CODE_OJ("Ojibwa", "OJ"),
    LANGUAGE_CODE_CU("ChurchSlavic, Old Slavonic, Church Slavonic, Old Bulgarian, Old Church Slavonic", "CU"),
    LANGUAGE_CODE_OM("Oromo", "OM"),
    LANGUAGE_CODE_OR("Oriya", "OR"),
    LANGUAGE_CODE_OS("Ossetian, Ossetic", "OS"),
    LANGUAGE_CODE_PA("Punjabi, Panjabi", "PA"),
    LANGUAGE_CODE_PI("Pali", "PI"),
    LANGUAGE_CODE_FA("Persian", "FA"),
    LANGUAGE_CODE_PL("Polish", "PL"),
    LANGUAGE_CODE_PS("Pashto, Pushto", "PS"),
    LANGUAGE_CODE_PT("Portuguese", "PT"),
    LANGUAGE_CODE_QU("Quechua", "QU"),
    LANGUAGE_CODE_RM("Romansh", "RM"),
    LANGUAGE_CODE_RN("Rundi", "RN"),
    LANGUAGE_CODE_RO("Romanian, Moldavian, Moldovan", "RO"),
    LANGUAGE_CODE_RU("Russian", "RU"),
    LANGUAGE_CODE_SA("Sanskrit", "SA"),
    LANGUAGE_CODE_SC("Sardinian", "SC"),
    LANGUAGE_CODE_SD("Sindhi", "SD"),
    LANGUAGE_CODE_SE("Northern Sami", "SE"),
    LANGUAGE_CODE_SM("Samoan", "SM"),
    LANGUAGE_CODE_SG("Sango", "SG"),
    LANGUAGE_CODE_SR("Serbian", "SR"),
    LANGUAGE_CODE_GD("Gaelic, Scottish Gaelic", "GD"),
    LANGUAGE_CODE_SN("Shona", "SN"),
    LANGUAGE_CODE_SI("Sinhala, Sinhalese", "SI"),
    LANGUAGE_CODE_SK("Slovak", "SK"),
    LANGUAGE_CODE_SL("Slovenian", "SL"),
    LANGUAGE_CODE_SO("Somali", "SO"),
    LANGUAGE_CODE_ST("Southern Sotho", "ST"),
    LANGUAGE_CODE_ES("Spanish, Castilian", "ES"),
    LANGUAGE_CODE_SU("Sundanese", "SU"),
    LANGUAGE_CODE_SW("Swahili", "SW"),
    LANGUAGE_CODE_SS("Swati", "SS"),
    LANGUAGE_CODE_SV("Swedish", "SV"),
    LANGUAGE_CODE_TA("Tamil", "TA"),
    LANGUAGE_CODE_TE("Telugu", "TE"),
    LANGUAGE_CODE_TG("Tajik", "TG"),
    LANGUAGE_CODE_TH("Thai", "TH"),
    LANGUAGE_CODE_TI("Tigrinya", "TI"),
    LANGUAGE_CODE_BO("Tibetan", "BO"),
    LANGUAGE_CODE_TK("Turkmen", "TK"),
    LANGUAGE_CODE_TL("Tagalog", "TL"),
    LANGUAGE_CODE_TN("Tswana", "TN"),
    LANGUAGE_CODE_TO("Tonga (Tonga Islands)", "TO"),
    LANGUAGE_CODE_TR("Turkish", "TR"),
    LANGUAGE_CODE_TS("Tsonga", "TS"),
    LANGUAGE_CODE_TT("Tatar", "TT"),
    LANGUAGE_CODE_TW("Twi", "TW"),
    LANGUAGE_CODE_TY("Tahitian", "TY"),
    LANGUAGE_CODE_UG("Uighur, Uyghur", "UG"),
    LANGUAGE_CODE_UK("Ukrainian", "UK"),
    LANGUAGE_CODE_UR("Urdu", "UR"),
    LANGUAGE_CODE_UZ("Uzbek", "UZ"),
    LANGUAGE_CODE_VE("Venda", "VE"),
    LANGUAGE_CODE_VI("Vietnamese", "VI"),
    LANGUAGE_CODE_VO("Volapük", "VO"),
    LANGUAGE_CODE_WA("Walloon", "WA"),
    LANGUAGE_CODE_CY("Welsh", "CY"),
    LANGUAGE_CODE_WO("Wolof", "WO"),
    LANGUAGE_CODE_FY("Western Frisian", "FY"),
    LANGUAGE_CODE_XH("Xhosa", "XH"),
    LANGUAGE_CODE_YI("Yiddish", "YI"),
    LANGUAGE_CODE_YO("Yoruba", "YO"),
    LANGUAGE_CODE_ZA("Zhuang, Chuang", "ZA"),
    LANGUAGE_CODE_ZU("Zulu", "ZU");

    private static final Map<String, LanguageCode> MAP_LANGUAGE_CODE = new HashMap<>();

    private final String languageName;
    private final String languageCode;

    LanguageCode(final String languageName, final String languageCode) {
        this.languageName = languageName;
        this.languageCode = languageCode;
    }


    static {
        for (final LanguageCode lc : EnumSet.allOf(LanguageCode.class)) {
            MAP_LANGUAGE_CODE.put(lc.getLanguageCode(), lc);
        }
    }

    @Override
    public String toString() {
        return "LanguageCode{" + "languageName='" + languageName + '\'' + ", languageCode='" + languageCode + '\'' + '}';
    }

    public static LanguageCode findLanguageByCode(final String languageCode) {

        return StringUtils.isNoneBlank(languageCode) ? MAP_LANGUAGE_CODE.get(languageCode.toUpperCase(Locale.US)) : null;
    }

    public static boolean exists(final String languageCode) {
        return StringUtils.isNoneBlank(languageCode) && MAP_LANGUAGE_CODE.containsKey(languageCode.toUpperCase(Locale.US));
    }
}
