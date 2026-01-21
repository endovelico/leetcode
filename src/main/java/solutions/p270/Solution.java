package solutions.p270;


import common.TreeNode;

class Solution {

    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        int closest = root.val;

        while (node != null) {
            if (Math.abs(node.val - target) < Math.abs(closest - target)
                    || (Math.abs(node.val - target) == Math.abs(closest - target) && node.val < closest)) {
                closest = node.val;
            }

            node = target < node.val ? node.left : node.right;
        }

        return closest;
    }

}