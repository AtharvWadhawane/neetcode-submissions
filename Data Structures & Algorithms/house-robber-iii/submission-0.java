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
class Solution {  // 0 ---> rob , 1 ---> skip
    public int rob(TreeNode root) {

        int[]state = maxi(root);

        return state[0] > state[1] ? state[0] : state[1];
    }

    private int[] maxi(TreeNode node){
        if(node == null) return new int[]{0,0};
        
        //post order ---> l - r -root
        int[]leftinfo = maxi(node.left);
        int[]rightinfo = maxi(node.right);

        int rob = node.val + leftinfo[1] + rightinfo[1];

        int skip = Math.max(leftinfo[0],leftinfo[1]) + Math.max(rightinfo[0],rightinfo[1]);

        return new int[]{rob,skip};
    }
}