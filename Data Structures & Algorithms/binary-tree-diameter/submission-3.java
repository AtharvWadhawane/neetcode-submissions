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
    //optimal approach --> calculate height(depth),diameter at every node 

    int ans = 0; //global var

    public  int depth(TreeNode root){
        if(root == null) return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        //diameter at a node = left height + right height

        ans = Math.max(ans, (leftDepth+rightDepth)); 

        return 1 + Math.max(leftDepth,rightDepth);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }
}
