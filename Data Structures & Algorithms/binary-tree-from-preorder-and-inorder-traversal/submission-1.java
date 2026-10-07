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
    int idx = 0; //preorder iterator

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return bob(preorder,0,inorder.length-1);

    }

    private TreeNode bob(int[]pre,int low, int high){
        if(low > high) return null;
        
        //form node
        TreeNode root = new TreeNode(pre[idx++]);

        //find this root in inorder array using hashmap
        int location = map.get(root.val);

        //form left and right using location boundary
        root.left = bob(pre,low,location-1);
        root.right = bob(pre,location+1,high);

        return root;
    }
}
