/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        dfs(root,p,q);

        return ans;

    }

    private int dfs(TreeNode curr,TreeNode p, TreeNode q){
        if(curr == null) return 0;

        int left = dfs(curr.left,p,q); // for 2 outoff how many  left is the ancestor 
        int right = dfs(curr.right,p,q); //for 2 outoff how many  right is the ancestor 

        int self = 0;
        //check if curr node is p or q 
        if(curr.val == p.val || curr.val == q.val) self = 1;

        //check for how many outoff p and q is current node ancestor for , l+r+self
        int total = left + right + self;

        if(total == 2 && ans == null){
            ans = curr;
        }

        return total;
    }
}