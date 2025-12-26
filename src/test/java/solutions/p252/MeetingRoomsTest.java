package solutions.p252;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MeetingRoomsTest {

    // Assumes you have:
    // public class Solution {
    //     public boolean canAttendMeetings(int[][] intervals) { ... }
    // }
    private final Solution solution = new Solution();

    @Test
    @DisplayName("Null intervals -> true (nothing to attend)")
    void nullIntervals() {
        assertTrue(solution.canAttendMeetings(null));
    }

    @Test
    @DisplayName("Empty intervals -> true")
    void emptyIntervals() {
        assertTrue(solution.canAttendMeetings(new int[][]{}));
    }

    @Test
    @DisplayName("Single interval -> true")
    void singleInterval() {
        assertTrue(solution.canAttendMeetings(new int[][]{{1, 2}}));
    }

    @Test
    @DisplayName("Non-overlapping sorted intervals -> true")
    void nonOverlappingSorted() {
        assertTrue(solution.canAttendMeetings(new int[][]{
                {0, 10},
                {10, 20},
                {20, 30}
        }));
    }

    @Test
    @DisplayName("Non-overlapping UNSORTED intervals -> true (should sort internally)")
    void nonOverlappingUnsorted() {
        assertTrue(solution.canAttendMeetings(new int[][]{
                {10, 20},
                {0, 10},
                {20, 30}
        }));
    }

    @Test
    @DisplayName("Overlapping intervals -> false")
    void overlappingSimple() {
        assertFalse(solution.canAttendMeetings(new int[][]{
                {0, 30},
                {5, 10},
                {15, 20}
        }));
    }

    @Test
    @DisplayName("Overlap when one starts before previous ends -> false")
    void overlappingEdge() {
        assertFalse(solution.canAttendMeetings(new int[][]{
                {1, 5},
                {4, 6}
        }));
    }

    @Test
    @DisplayName("Touching at boundary (end == nextStart) -> true per LeetCode convention")
    void boundaryTouchingIsOk() {
        assertTrue(solution.canAttendMeetings(new int[][]{
                {1, 5},
                {5, 8}
        }));
    }

    @Test
    @DisplayName("Duplicate exact interval -> false")
    void duplicateInterval() {
        assertFalse(solution.canAttendMeetings(new int[][]{
                {1, 3},
                {1, 3}
        }));
    }

    @Test
    @DisplayName("Negative times non-overlapping -> true")
    void negativeTimesNonOverlapping() {
        assertTrue(solution.canAttendMeetings(new int[][]{
                {-10, -5},
                {-5, 0},
                {0, 2}
        }));
    }

    @Test
    @DisplayName("Negative times overlapping -> false")
    void negativeTimesOverlapping() {
        assertFalse(solution.canAttendMeetings(new int[][]{
                {-10, -1},
                {-5, 0}
        }));
    }

    @Test
    @DisplayName("Large values non-overlapping -> true")
    void largeValuesNonOverlapping() {
        assertTrue(solution.canAttendMeetings(new int[][]{
                {Integer.MIN_VALUE, -1},
                {-1, 0},
                {0, Integer.MAX_VALUE}
        }));
    }
}
