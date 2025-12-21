package solutions.p228;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Tester {

    private final Solution solution = new Solution();

    @Test
    void emptyArray() {
        int[] nums = {};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of(), result);
    }

    @Test
    void singleElement() {
        int[] nums = {5};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of("5"), result);
    }

    @Test
    void noRangesAllSingleNumbers() {
        int[] nums = {1, 3, 5, 7};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of("1", "3", "5", "7"), result);
    }

    @Test
    void oneContinuousRange() {
        int[] nums = {1, 2, 3, 4, 5};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of("1->5"), result);
    }

    @Test
    void mixedRanges() {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of("0->2", "4->5", "7"), result);
    }

    @Test
    void negativeNumbers() {
        int[] nums = {-3, -2, -1, 1, 2};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of("-3->-1", "1->2"), result);
    }

    @Test
    void largeGapBetweenNumbers() {
        int[] nums = {1, 2, 100};
        List<String> result = solution.summaryRanges(nums);

        assertEquals(List.of("1->2", "100"), result);
    }
}
