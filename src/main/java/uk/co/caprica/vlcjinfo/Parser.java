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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Simple state-machine parser for the 'raw' data returned by MediaInfo.
 */
final class Parser {

    /**
     * Enumeration of machine states.
     */
    private enum ParseState {
        DEFAULT,
        NEXT_SECTION,
        SECTION,
        FINISHED
    }

    /**
     * Raw data to parse.
     */
    private final String data;

    /**
     * Current parse state.
     */
    private ParseState parseState = ParseState.DEFAULT;

    /**
     * Create a new parser.
     *
     * @param data raw data to parser
     */
    Parser(String data) {
        this.data = data;
    }

    /**
     * Parse the raw data.
     *
     * @return parsed media information
     */
    MediaInfo parse() {
        try {
            BufferedReader reader = new BufferedReader(new StringReader(data));
            MediaInfo mediaInfo = new MediaInfo();
            String sectionName;
            String line;
            Sections sections;
            Section section = null;
            while (parseState != ParseState.FINISHED) {
                switch (parseState) {
                    case DEFAULT:
                        parseState = ParseState.NEXT_SECTION;
                        break;
                    case NEXT_SECTION:
                        sectionName = reader.readLine();
                        if (sectionName == null) {
                            parseState = ParseState.FINISHED;
                        }
                        else if (sectionName.length() > 0) {
                            parseState = ParseState.SECTION;
                            sections = mediaInfo.sections(sectionName);
                            section = sections.newSection();
                        }
                        break;
                    case SECTION:
                        line = reader.readLine();
                        if (line == null) {
                            parseState = ParseState.FINISHED;
                        }
                        else if (line.length() == 0) {
                            parseState = ParseState.NEXT_SECTION;
                        }
                        else {
                            // Quick fix for value that has multiple colon(:)
                            String[] values = line.split(":");

                            assert section != null;

                            if (values.length > 2) {
                                StringBuilder sb = new StringBuilder();
                                String finalValue;

                                for (int x = 1; x < values.length; x++) {
                                    sb.append(values[x].trim()).append(":");
                                }

                                finalValue = sb.toString();

                                section.put(values[0].trim(), finalValue.substring(0, finalValue.length() - 1));
                            } else {
                                section.put(values[0].trim(), values[1].trim());
                            }
                        }
                        break;
                    default:
                        throw new IllegalStateException();
                }
            }
            return mediaInfo;
        }
        catch (IOException e) {
            throw new MediaInfoParseException("Failed to parse media info", e);
        }
    }
}
