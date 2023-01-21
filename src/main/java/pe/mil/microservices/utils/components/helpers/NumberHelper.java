package pe.mil.microservices.utils.components.helpers;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberHelper {

    String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static boolean dniNumber(String value) {
        return onlyNumber(value).length() == 8;
    }

    public static boolean cipNumber(String value) {
        return onlyNumber(value).length() == 9;
    }

    private String onlyNumber(String value) {
        String number;
        StringBuilder dni = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            number = value.substring(i, i + 1);
            for (String digit : digits) {
                if (number.equals(digit)) {
                    dni.append(digit);
                }
            }
        }

        return dni.toString();
    }
}
