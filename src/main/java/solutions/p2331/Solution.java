package solutions.p2331;

import common.TreeNode;

public class Solution {

    public boolean evaluateTree(TreeNode root) {

        if(root.left == null && root.right == null) {

            return root.val == 1;
        }

        boolean left_evaluation = evaluateTree(root.left);
        boolean right_evaluation = evaluateTree(root.right);


        if (root.val == 2) {
            return left_evaluation || right_evaluation; // OR
        } else { // root.val == 3
            return left_evaluation && right_evaluation; // AND
        }
    }

}
