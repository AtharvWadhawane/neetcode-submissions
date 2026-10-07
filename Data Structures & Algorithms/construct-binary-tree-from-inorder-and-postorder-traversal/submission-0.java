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
    HashMap<Integer,Integer>map = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
            return bob(postorder,0,inorder.length-1);
    }

    private TreeNode bob(int[]post,int low,int high){
        if(low > high) return null;

        TreeNode root = new TreeNode(post[idx--]);

        int location = map.get(root.val);

        root.right = bob(post,location+1,high);
        root.left = bob(post,low,location-1);

        return root;
    }
}