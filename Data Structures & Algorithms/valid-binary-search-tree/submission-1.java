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
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean check(TreeNode root,long left ,long right){
        if(root == null) return true;

        // if(root.left!=null && root.val<= root.left.val) return false; 
        // if(root.right!=null && root.val>= root.right.val) return false;
        /*
        the above two lines only compare node with its root node , we need to compare with who tree
        values thus our root=[5,4,6,null,null,3,7] test case failed 
        */
        
        if(!(left<root.val && root.val<right)) return false;
        

        return check(root.left,left,root.val) && check(root.right,root.val,right);
    }
}
