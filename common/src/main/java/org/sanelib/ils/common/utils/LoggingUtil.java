package org.sanelib.ils.common.utils;

import java.lang.reflect.Array;

public class LoggingUtil {
    private static final String NO_ARGS = "[no args]";
    private static final String COMMA = ",";
    private static final String QUOTE = "'";
    private static final String END_SQUARE = "]";
    private static final String START_SQUARE = "[";

    private static final String MIN_VALUE = "0";
    private static final String COLON = ":";
    private static final String RANGE_PATTERN = "\\d*:\\d*";

    public static String buildArgInfoString(Object[] args) {
        StringBuilder sb = new StringBuilder();

        if (args != null && args.length > 0) {
            sb.append(START_SQUARE);
            for (Object arg : args) {
                if (arg != null && arg.getClass().isArray()) {
                    sb.append(arrayToString(arg));
                } else {
                    sb.append(arg);
                }
                sb.append(COMMA);
            }

            sb.replace(sb.length() - 1, sb.length(), END_SQUARE);
        } else {
            sb.append(NO_ARGS);
        }

        return sb.toString();
    }

    public static String arrayToString(Object array) {
        StringBuilder sb = new StringBuilder();
        String arrayAsString = null;

        if (array != null) {
            sb.append(START_SQUARE);
            for (int i = 0; i < Array.getLength(array); i++) {
                sb.append(Array.get(array, i));
                sb.append(COMMA);
            }
            sb.replace(sb.length() - 1, sb.length(), END_SQUARE);

            arrayAsString = sb.toString();
        }

        return arrayAsString;
    }
}
