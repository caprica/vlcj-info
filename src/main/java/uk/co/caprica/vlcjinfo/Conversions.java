/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2015 Caprica Software Limited.
 */

package uk.co.caprica.vlcjinfo;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Encapsulation of datatype conversions.
 */
final class Conversions {

    /**
     * Regular expression pattern to extract an integer value.
     */
    private static final Pattern INTEGER_PATTERN = Pattern.compile("(\\-?[\\d\\s]+)(?:\\s?\\w+)?");

    /**
     * Regular expression pattern to extract a decimal value.
     */
    private static final Pattern DECIMAL_PATTERN = Pattern.compile("(\\d+\\.\\d+)(?: \\w+)?");

    /**
     * Regular expression pattern to extract a duration value.
     */
    private static final Pattern DURATION_PATTERN = Pattern.compile("(?:(\\-?\\d+)\\s*h)?\\s*(?:(\\-?\\d+)\\s*m(?:in)?)?\\s*(?:(\\-?\\d+)\\s*s)?\\s*(?:(\\-?\\d+)\\s*ms)?");

    /**
     * Prevent direct instantiation by others.
     */
    private Conversions() {
    }

    /**
     * Convert a string to an integer.
     *
     * @param value value to convert
     * @return converted value, or <code>null</code> if the supplied value was <code>null</code>
     * @throws IllegalArgumentException if the supplied value could not be parsed
     */
    static Integer integer(String value) {
        Integer result;
        if (value != null) {
            value = value.trim();
            Matcher matcher = INTEGER_PATTERN.matcher(value);
            if (matcher.matches()) {
                result = Integer.parseInt(matcher.group(1).replace(" ", ""));
            } else {
                throw new IllegalArgumentException("Unknown format for value: " + value);
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Convert a string to a big decimal.
     *
     * @param value value to convert
     * @return converted value, or <code>null</code> if the supplied value was <code>null</code>
     * @throws IllegalArgumentException if the supplied value could not be parsed
     */
    static BigDecimal decimal(String value) {
        BigDecimal result;
        if (value != null) {
            value = value.trim();
            Matcher matcher = DECIMAL_PATTERN.matcher(value);
            if (matcher.matches()) {
                result = new BigDecimal(matcher.group(1));
            } else {
                throw new IllegalArgumentException("Unknown format for value: " + value);
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Convert a string to a duration.
     *
     * @param value value to convert
     * @return converted value, or <code>null</code> if the supplied value was <code>null</code>
     * @throws IllegalArgumentException if the supplied value could not be parsed
     */
    static Duration duration(String value) {
        Duration result;
        if (value != null) {
            value = value.trim();
            Matcher matcher = DURATION_PATTERN.matcher(value);
            if (matcher.matches()) {
                int hours = matcher.group(1) != null ? Integer.parseInt(matcher.group(1)) : 0;
                int minutes = matcher.group(2) != null ? Integer.parseInt(matcher.group(2)) : 0;
                int seconds = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 0;
                int millis = matcher.group(4) != null ? Integer.parseInt(matcher.group(4)) : 0;
                result = new Duration(hours, minutes, seconds, millis);
            } else {
                throw new IllegalArgumentException("Unknown format for value: " + value);
            }
        } else {
            result = null;
        }
        return result;
    }

    // FIXME UTC date?
}
