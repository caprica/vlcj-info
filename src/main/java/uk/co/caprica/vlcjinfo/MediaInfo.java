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

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import uk.co.caprica.vlcjinfo.binding.LibMediaInfo;

import com.sun.jna.Pointer;
import com.sun.jna.WString;

/**
 * Factory class that creates and parses media information.
 * <p>
 * This class opens the file, parses the data in bulk, and closes the file.
 * <p>
 * See {@link MediaInfoFile} for more fine-grained access.
 */
public final class MediaInfo {

    /**
     * Map of sections keyed by their type name.
     */
    private final Map<String,Sections> sectionsByType = new LinkedHashMap<String,Sections>();

    /**
     * Extract media information for a particular file.
     *
     * @param filename name of the file
     * @return media information
     * @throws MediaInfoParseException if a parse error occurs
     */
    public static MediaInfo mediaInfo(String filename) {
        MediaInfo result;
        LibMediaInfo lib = LibMediaInfo.INSTANCE;
        Pointer handle = lib.MediaInfo_New();
        if (handle != null) {
            try {
                int opened = lib.MediaInfo_Open(handle, new WString(filename));
                if (opened == 1) {
                    WString data = lib.MediaInfo_Inform(handle);
                    lib.MediaInfo_Close(handle);
                    result = new Parser(data.toString()).parse();
                }
                else {
                    result = null;
                }
            }
            finally {
                lib.MediaInfo_Delete(handle);
            }
        }
        else {
            result = null;
        }
        return result;
    }

    /**
     * Get all of the sections of a particular type.
     *
     * @param type section type
     * @return list of sections of the requested type, or <code>null</code> if there are no sections of that type
     */
    public Sections sections(String type) {
        Sections result = sectionsByType.get(type);
        if (result == null) {
            result = new Sections();
            sectionsByType.put(type,  result);
        }
        return result;
    }

    /**
     * Get the first section of a particular type.
     *
     * @param type section type
     * @return first section of the requested type, or <code>null</code> if there are no sections of that type
     */
    public Section first(String type) {
        Section result;
        Sections sections = sections(type);
        if (sections != null) {
            result = sections.first();
        }
        else {
            result = null;
        }
        return result;
    }

    /**
     * Dump out the media information in a readable format.
     * <p>
     * This is easier to read than a standard {@link #toString()}.
     * <p>
     * This should only be used for debugging purposes.
     *
     * @param writer writer to dump the media information to
     */
    public void dump(Writer writer) {
        PrintWriter printer = new PrintWriter(writer);
        for (String sectionType : sectionsByType.keySet()) {
            int sectionNumber = 0;
            for (Section section : sectionsByType.get(sectionType)) {
                printer.printf("%s [%d]%n", sectionType, sectionNumber++);
                for (String key : section) {
                    printer.printf(" %30s -> %s%n", key, section.value(key));
                }
            }
            printer.println();
        }
        try {
            writer.flush();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(getClass().getSimpleName()).append('[');
        sb.append("sectionsByType=").append(sectionsByType).append(']');
        return sb.toString();
    }
}
