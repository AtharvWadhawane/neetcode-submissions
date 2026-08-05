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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        //same method name - method overloading 
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);

        return root;
    }
    //here for both array we have 2 pointers each start and end
    public TreeNode buildTree(int[]preorder,int preStart,int preEnd,
    int[]inorder, int inStart, int inEnd,
    Map<Integer,Integer>map){

        //when will stop , when start pointer crosses end pointer

        if(preStart>preEnd || inStart>inEnd) return null;

        //my main root is the first element of preorder(Root-Left-Right)
        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val); //we retrieveing index 
        //now we separate 
        int numsOnLeft = inRoot - inStart;

        root.left = buildTree(preorder,preStart+1,preStart+numsOnLeft,
                            inorder,inStart,inRoot,map);

        root.right = buildTree(preorder,preStart+numsOnLeft+1,preEnd,
                            inorder,inRoot+1,inEnd,map);

        return root;
    }
}
