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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        find(root);
        return ans;
    }
    private int find(TreeNode node){
        if(node == null) return 0;

        int leftheight = find(node.left);
        int rightheight = find(node.right);

        if(Math.abs(leftheight - rightheight) > 1) ans = false;

        return 1 + Math.max(leftheight,rightheight); // current node height
    }
}
