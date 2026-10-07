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

 //Eazyyyy --> inorder traversal gives us the sorted order , we do just in time check
class Solution {
    
    TreeNode prev = null;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return ans;   
    }

    private void inorder(TreeNode node){
        if(node == null || !ans) return;

        inorder(node.left);

        if(prev == null) prev = node;

        else{
            if(node.val <= prev.val) {
                ans = false;
                return;
            }
            prev = node;
        }

        inorder(node.right);
    }
}