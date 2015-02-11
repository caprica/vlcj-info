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
public class Duration {

    private final int hours;

    private final int minutes;

    private final int seconds;

    private final int millis;

    public Duration(int hours, int minutes, int seconds, int millis) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.millis = millis;
    }

    public int hours() {
        return hours();
    }

    public int minutes() {
        return minutes;
    }

    public int seconds() {
        return seconds;
    }

    public int millis() {
        return millis;
    }

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
