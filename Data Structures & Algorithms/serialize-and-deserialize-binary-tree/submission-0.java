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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr == null){
                sb.append("null,");
                continue;
            }
            sb.append(curr.val).append(",");

            queue.offer(curr.left);
            queue.offer(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] s = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            //left node
            if(!s[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                curr.left = left;
                queue.offer(left);
            }
            i++;
             if(!s[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                curr.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}
