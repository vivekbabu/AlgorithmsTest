package in.algorithms.roomalotter;

import java.util.Arrays;

public class RoomAlotter {
    public static int minMeetingRooms(int[] start, int[] end) {
        if (start == null || end == null || start.length == 0) return 0;
        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0;
        int endPtr = 0;

        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endPtr]) {
                rooms++;
            } else {
                endPtr++;
            }
        }
        return rooms;
    }
}
