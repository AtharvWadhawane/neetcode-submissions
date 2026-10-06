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
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean seenflag = false;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) 
                seenflag = true;

            else { //not null

            //once seen all should be null, if not then return false
                if (seenflag) {
                    return false;
                }

                queue.add(curr.left);
                queue.add(curr.right);
            }

        }
        return true;
    }
}