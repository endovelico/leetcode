package solutions.p252;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public boolean canAttendMeetings(int[][] intervals) {
        // Edge cases
        if (intervals == null || intervals.length <= 1) {
            return true;
        }

        // Sort intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
