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

package uk.co.caprica.vlcjinfo.binding;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.WString;

/**
 * Minimal binding to the MediaInfo native library.
 */
public interface LibMediaInfo extends Library {

    LibMediaInfo INSTANCE = Native.load(Platform.isWindows() ? "MediaInfo" : "mediainfo", LibMediaInfo.class);

    Pointer MediaInfo_New();

    void MediaInfo_Delete(Pointer handle);

    int MediaInfo_Open(Pointer handle, WString filename);

    void MediaInfo_Close(Pointer handle);

    WString MediaInfo_Option(Pointer handle, WString parameter, WString value);

    WString MediaInfo_Inform(Pointer handle);

}
