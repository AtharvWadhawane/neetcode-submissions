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

    //brute force 

    public static int  depth(TreeNode root){
        if(root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return 1 + Math.max(leftDepth,rightDepth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;

        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        int currDia = depth(root.left) + depth(root.right);

        return Math.max(currDia,Math.max(rightDia,leftDia));
    }
}
