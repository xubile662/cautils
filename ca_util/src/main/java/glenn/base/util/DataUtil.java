package glenn.base.util;

import android.util.Log;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

public class DataUtil {

    public static String DEFAULT_FORMAT = "dd MMMM yyyy";

    public static String getFormattedDateStringFromServerResponse(String serverResponse, String format) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(serverResponse.split("//+")[0]);
        return new SimpleDateFormat(format).format(date);
    }

    public static String getDateString(long value) {
        return getDateString(value, DEFAULT_FORMAT);
    }


    public static String getDateString(long value, String format) {
        return getDateString(value, format, false, 7);
    }

    public static String getDateString(long value, String format, boolean isUnix, int gmt) {
        long unix = isUnix ? 1000L : 1L;
        Locale locale = new Locale("id", "ID");
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+" + gmt));
        return dateFormat.format(new Date(value * unix));

    }

    public static String convertCurrency(Object value) {
        String v = String.valueOf(value);
        String price = "Rp ";
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        try {
            String temp = numberFormat.format(Double.parseDouble(v));
            price += temp.replace(",", ".");
            price = price.replace("-", "");
        } catch (Exception e) {
            e.printStackTrace();
            price += "0";
        }
        return price;
    }

    public static long convertLongFromCurrency(String value) {
        if (value != null) {
            try {
                return Long.valueOf(value.replaceAll("\\D", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int getInt(String value) {
        if (value != null) {
            try {
                return Integer.valueOf(value.replaceAll("\\D", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int convertIntFromCurrency(String value) {
        return convertIntFromCurrency(value, true);
    }

    public static int convertIntFromCurrency(String value, boolean isClearDecimal) {
        return convertIntFromCurrency(value, isClearDecimal, ".");
    }

    public static int convertIntFromCurrency(String value, boolean isClearDecimal, String separator) {
        if (value != null) {
            try {
                if (isClearDecimal) {
                    value = value.substring(0, value.lastIndexOf(separator));
                }
                return Integer.valueOf(value.replaceAll("\\D", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static String cleanDigit(String value) {
        if (value != null) {
            try {
                return value.replaceAll("[\\d\\s]", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String getXXXPhone(String phone) {
        return phone.substring(0, phone.length() - 7) + "XXXX" + phone.substring(phone.length() - 3, phone.length());
    }

    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(16);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}
