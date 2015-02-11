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
 *
 */
public final class Section implements Iterable<String> {

    /**
     *
     */
    private final Map<String,String> values = new TreeMap<String,String>();

    /**
     *
     */
    Section() {
    }

    /**
     *
     *
     * @param key
     * @param value
     */
    void put(String key, String value) {
        values.put(key, value);
    }

    /**
     *
     *
     * @param key
     * @return
     */
    public String value(String key) {
        return values.get(key);
    }

    /**
     *
     *
     * @param key
     * @return
     */
    public Integer integer(String key) {
        return Conversions.integer(value(key));
    }

    /**
     *
     *
     * @param key
     * @return
     */
    public BigDecimal decimal(String key) {
        return Conversions.decimal(value(key));
    }

    /**
     *
     *
     * @param key
     * @return
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
