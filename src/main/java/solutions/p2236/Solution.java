package solutions.p2236;

import common.TreeNode;

import java.util.*;

public class Solution {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
