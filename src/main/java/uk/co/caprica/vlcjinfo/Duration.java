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

/**
 * Encapsulation of a duration.
 */
public final class Duration {

    /**
     * Number of hours.
     */
    private final int hours;

    /**
     * Number of minutes.
     */
    private final int minutes;

    /**
     * Number of seconds.
     */
    private final int seconds;

    /**
     * Number of milliseconds.
     */
    private final int millis;

    /**
     * Create a new duration.
     * <p>
     * An attempt will be made to parse the supplied value string and create a duration instance from it.
     *
     * @param value value
     * @return duration
     * @throws IllegalArgumentException if the supplied value string could not be parsed
     */
    public static Duration duration(String value) {
        return Conversions.duration(value);
    }

    /**
     * Create a duration.
     *
     * @param hours number of hours
     * @param minutes number of minutes
     * @param seconds number of seconds
     * @param millis number of milliseconds
     */
    public Duration(int hours, int minutes, int seconds, int millis) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.millis = millis;
    }

    /**
     * Get the number of hours.
     *
     * @return hours
     */
    public int hours() {
        return hours();
    }

    /**
     * Get the number of minutes.
     *
     * @return minutes
     */
    public int minutes() {
        return minutes;
    }

    /**
     * Get the number of seconds.
     *
     * @return seconds
     */
    public int seconds() {
        return seconds;
    }

    /**
     * Get the number of milliseconds.
     *
     * @return milliseconds
     */
    public int millis() {
        return millis;
    }

    /**
     * Get the duration as a number of milliseconds.
     *
     * @return this duration as a number of milliseconds
     */
    public long asMilliSeconds() {
        return (((((hours * 60) + minutes) * 60) + seconds) * 1000) + millis;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("hours=").append(hours).append(',');
        sb.append("minutes=").append(minutes).append(',');
        sb.append("seconds=").append(seconds).append(',');
        sb.append("millis=").append(millis).append(',');
        sb.append("asMilliSeconds=").append(asMilliSeconds()).append(']');
        return sb.toString();
    }
}
