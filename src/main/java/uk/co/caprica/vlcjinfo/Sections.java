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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Encapsulation of one or more sections.
 */
public final class Sections implements Iterable<Section> {

    /**
     * List of sections.
     */
    private final List<Section> sections = new ArrayList<Section>();

    /**
     * Create, and add, a new empty section.
     *
     * @return
     */
    Section newSection() {
        Section result = new Section();
        sections.add(result);
        return result;
    }

    /**
     * Get the list of sections.
     *
     * @return sections list, unmodifiable
     */
    public List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    /**
     * Get the first section.
     *
     * @return section
     */
    public Section first() {
        return sections.get(0);
    }

    @Override
    public Iterator<Section> iterator() {
        return sections.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("sections=").append(sections).append(']');
        return sb.toString();
    }
}
