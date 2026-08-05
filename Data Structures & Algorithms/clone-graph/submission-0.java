/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node,Node>visited = new HashMap<>(); // old and new node

    public Node cloneGraph(Node node) {
        if(node == null)return null;

        return dfs(node);
    }
    private Node dfs(Node node){
        
        if(visited.containsKey(node)) return visited.get(node);

        //create clone 
        Node clone = new Node(node.val);
        visited.put(node,clone);

        for(Node nb : node.neighbors){
            clone.neighbors.add(dfs(nb));
        }
        return clone;
    }
}



