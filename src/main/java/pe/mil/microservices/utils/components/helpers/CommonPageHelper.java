package pe.mil.microservices.utils.components.helpers;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.UUID;

@UtilityClass
public class CommonPageHelper {

    public static String generateUUIDRandom() {
        return UUID.randomUUID().toString();
    }

    public static BigInteger longToBigInteger(long value) {
        return BigInteger.valueOf(value);
    }

    public static boolean bigIntegerIsGreaterThan(BigInteger value1, BigInteger value2) {
        return value1.compareTo(value2) > 0;
    }

    public static BigDecimal divideAndRounding(BigDecimal value1, BigDecimal value2) {
        return value1.divide(value1, RoundingMode.CEILING);
    }

    public static BigDecimal getLastPage(BigInteger totalRecords, String limit) {
        return bigIntegerIsGreaterThan(totalRecords, BigInteger.ZERO)
            ? divideAndRounding(new BigDecimal(totalRecords), new BigDecimal(limit))
            : BigDecimal.ZERO;
    }

    public static BigInteger getNextPageNumber(String page) {
        return new BigInteger(page).add(BigInteger.ONE);
    }

    public static BigInteger previousPageNumber(String page) {
        return new BigInteger(page).subtract(BigInteger.ONE);
    }

    public static String getNextPageNumber(BigInteger nextPageNumber, BigInteger lastPage, String limit) {
        return nextPageNumber.compareTo(lastPage) > 0 ? null : "?page=" + nextPageNumber + "&limit=" + limit;
    }

    public static String getPreviousPageNumber(BigInteger previousPageNumber, BigInteger lastPage, String limit) {
        return previousPageNumber.compareTo(lastPage) > 0 ? null : "?page=" + previousPageNumber + "&limit=" + limit;
    }

    public static String getLastPage(BigDecimal lastPage, String limit) {
        return lastPage.equals(BigDecimal.ZERO) ? null : "?page=" + lastPage + "&limit=" + limit;
    }

    public static String getFirstPage(BigInteger totalRecords, String limit) {
        return totalRecords.compareTo(BigInteger.ZERO) == 0 ? null : "?page=1&limit=" + limit;
    }
}
