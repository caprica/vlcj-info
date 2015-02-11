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

import java.io.OutputStreamWriter;

public class VlcjInfoTest {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Specify a media file name");
            System.exit(1);
        }

        MediaInfo mediaInfo = MediaInfo.mediaInfo(args[0]);
        mediaInfo.dump(new OutputStreamWriter(System.out));

        Section video = mediaInfo.first("Video");
        Integer width = video.integer("Width");
        Integer height = video.integer("Height");

        System.out.printf("%d x %d%n", width, height);
        System.out.printf("ID %d%n", video.integer("ID"));
        System.out.printf("Duration %s%n", video.duration("Duration"));
        System.out.printf("Frame rate %f%n", video.decimal("Frame rate"));
    }
}
