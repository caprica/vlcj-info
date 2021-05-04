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

public class DurationTest {

    public static void main(String[] args) throws Exception {
        Section test = new Section();

        test.put("Duration", "1h");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1 h");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1  h");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h 20m");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1 h 20 m");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h 20min");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h 20 min");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h 20 min 39s");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h 20 min 39 s");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1  h 20  min 39  s");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h  20m  39s");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1 h  20 m  39 s");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1  h  20  min  39  s");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "1h  20m 39s 43ms");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "  1  h    20   m       39  s         43  ms  ");
        System.out.printf("Duration %s%n", test.duration("Duration"));

        test.put("Duration", "  1  h    20   min       39  s         43  ms  ");
        System.out.printf("Duration %s%n", test.duration("Duration"));
    }

}
