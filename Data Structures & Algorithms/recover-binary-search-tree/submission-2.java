
class Solution {
    TreeNode prev , first , second;
    public void recoverTree(TreeNode root) {
        prev = first = second = null;
        inorder(root);

        if(first !=null && second !=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);

        if(prev!=null && prev.val > node.val){ 
            
            if(first == null){ //1st violation 
                first = prev;
                second = node;
            }
            else{ //2nd violation
                second = node; //update second
            }
        }

        prev = node;

        inorder(node.right);   
    }
}