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
    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode last;

    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);

        if(first!=null && last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first!=null && middle!=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }

    private  void inorder(TreeNode node){ //left-root-right

        if(node == null) return;

        inorder(node.left);
        
        if(prev!=null && prev.val > node.val){

            if(first == null){ //first violation 
                first = prev;
                middle  = node;
            }
            else{ //second violation 
                last = node;
            }
        }
        prev = node;
        inorder(node.right);
    }
}