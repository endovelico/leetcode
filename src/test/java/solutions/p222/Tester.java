package solutions.p222;
import common.TreeNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tester {

     Solution solution = new Solution();

    // Tree:
    //         1
    //       /   \
    //      2     3
    //     / \   /
    //    4   5 6
    @Test
    public void testCompleteTreeWithSixNodes() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int result = solution.countNodes(root);
        assertEquals(6, result);
    }

    // Tree:
    //         1
    //       /   \
    //      2     3
    //     /
    //    4
    @Test
    public void testCBTWithFourNodes() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int result = solution.countNodes(root);
        assertEquals(4, result);
    }

    // Tree:
    //         1
    //       /   \
    //      2     3
    //     / \
    //    4   5
    @Test
    public void testCBTWithFiveNodes() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
    }

}