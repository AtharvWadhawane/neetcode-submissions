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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean LtoR = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();

                if(LtoR){
                    dq.addLast(curr.val);
                }else{
                    dq.addFirst(curr.val);
                }
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);

            }
                result.add(new ArrayList<>(dq));
                LtoR = !(LtoR);
        }
        return result;    
    }
}