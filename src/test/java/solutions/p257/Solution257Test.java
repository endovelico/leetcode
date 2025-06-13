package solutions.p257;

import common.TreeNode;
import org.junit.jupiter.api.Test;
import solutions.p257.Solution;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class Solution257Test {

    private final Solution solution = new Solution();

    private TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        return root;
    }

    @Test
    public void testBinaryTreePaths_Basic() {
        TreeNode root = buildSampleTree();
        List<String> expected = Arrays.asList("1->2->5", "1->3");
        List<String> actual = solution.binaryTreePaths(root);

        assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    }

    @Test
    public void testBinaryTreePaths_SingleNode() {
        TreeNode root = new TreeNode(42);
        List<String> expected = List.of("42");
        List<String> actual = solution.binaryTreePaths(root);

        assertEquals(expected, actual);
    }

    @Test
    public void testBinaryTreePaths_Empty() {
        TreeNode root = null;
        List<String> actual = solution.binaryTreePaths(root);

        assertTrue(actual.isEmpty());
    }
}
