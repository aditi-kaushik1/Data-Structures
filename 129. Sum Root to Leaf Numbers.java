/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        int ans = helper(root, 0);
        return ans;
    }

    public int helper(TreeNode root, int parentNumber) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null) {
            int current = parentNumber*10 + root.val;
            return current;
        }
        return helper(root.left, parentNumber*10 + root.val)
         + helper(root.right, parentNumber*10 + root.val);
    }
}
