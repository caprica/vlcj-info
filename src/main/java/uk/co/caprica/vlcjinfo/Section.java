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
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Encapsulation of a section.
 */
public final class Section implements Iterable<String> {

    /**
     * Map of key, value pairs for the section.
     */
    private final Map<String,String> values = new TreeMap<String,String>();

    /**
     * Create a section.
     */
    Section() {
    }

    /**
     * Add a key, value pair.
     *
     * @param key key
     * @param value value
     */
    void put(String key, String value) {
        values.put(key, value);
    }

    /**
     * Get the value for a particular key.
     *
     * @param key key to get the value for
     * @return value, or <code>null</code> if the key is not in the section
     */
    public String value(String key) {
        return values.get(key);
    }

    /**
     * Get an integer value for a particular key.
     *
     * @param key key to get the value for
     * @return integer value, or <code>null</code> if the key is not in the section
     */
    public Integer integer(String key) {
        return Conversions.integer(value(key));
    }

    /**
     * Get a big decimal value for a particular key.
     *
     * @param key key to get the value for
     * @return big decimal value, or <code>null</code> if the key is not in the section
     */
    public BigDecimal decimal(String key) {
        return Conversions.decimal(value(key));
    }

    /**
     * Get an duration value for a particular key.
     *
     * @param key key to get the value for
     * @return duration value, or <code>null</code> if the key is not in the section
     */
    public Duration duration(String key) {
        return Conversions.duration(value(key));
    }

    @Override
    public Iterator<String> iterator() {
        return values.keySet().iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("values=").append(values).append(']');
        return sb.toString();
    }
}
