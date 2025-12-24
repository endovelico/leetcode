package solutions.p246;

import org.junit.jupiter.api.Test;
import solutions.p246.Solution;

import static org.junit.jupiter.api.Assertions.*;

public class StrobogrammaticNumberTest {

    private final Solution solution = new Solution();

    @Test
    void testSingleDigitValid() {
        assertTrue(solution.isStrobogrammatic("0"));
        assertTrue(solution.isStrobogrammatic("1"));
        assertTrue(solution.isStrobogrammatic("8"));
    }

    @Test
    void testSingleDigitInvalid() {
        assertFalse(solution.isStrobogrammatic("2"));
        assertFalse(solution.isStrobogrammatic("3"));
        assertFalse(solution.isStrobogrammatic("7"));
    }

    @Test
    void testTwoDigitsValid() {
        assertTrue(solution.isStrobogrammatic("11"));
        assertTrue(solution.isStrobogrammatic("69"));
        assertTrue(solution.isStrobogrammatic("96"));
        assertTrue(solution.isStrobogrammatic("88"));
    }

    @Test
    void testTwoDigitsInvalid() {
        assertFalse(solution.isStrobogrammatic("10"));
        assertFalse(solution.isStrobogrammatic("12"));
        assertFalse(solution.isStrobogrammatic("67"));
    }

    @Test
    void testMultipleDigitsValid() {
        assertTrue(solution.isStrobogrammatic("818"));
        assertTrue(solution.isStrobogrammatic("619"));
        assertTrue(solution.isStrobogrammatic("906"));
    }

    @Test
    void testMultipleDigitsInvalid() {
        assertFalse(solution.isStrobogrammatic("962"));
        assertFalse(solution.isStrobogrammatic("1012"));
        assertFalse(solution.isStrobogrammatic("8889"));
    }

    @Test
    void testEdgeCases() {
        assertTrue(solution.isStrobogrammatic("")); // LeetCode considers empty valid
        assertFalse(solution.isStrobogrammatic("6"));
        assertFalse(solution.isStrobogrammatic("9"));
    }
}
