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
 * Copyright 2015-2021 Caprica Software Limited.
 */

package uk.co.caprica.vlcjinfo;

/**
 * Exception thrown if the media information could not be parsed.
 */
public final class MediaInfoParseException extends RuntimeException {

    /**
     * Create an exception.
     *
     * @param message exception message
     * @param cause root cause of the exception
     */
    public MediaInfoParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
