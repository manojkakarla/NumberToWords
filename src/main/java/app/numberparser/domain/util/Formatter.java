package app.numberparser.domain.util;

import java.text.DecimalFormat;

public class Formatter {
    private static final String DEFAULT_FORMAT = "000,000,000";
    private static DecimalFormat formatter = new DecimalFormat(DEFAULT_FORMAT);

    public static String format(Integer number) {
        return formatter.format(number);
    }
}
