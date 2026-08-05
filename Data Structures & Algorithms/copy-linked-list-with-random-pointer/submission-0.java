/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node>m = new HashMap<>();

        Node temp = head;
        //create  node copies

        while(temp!=null){
            m.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        //now lets do the wiring (next and random)
        Node curr = head;
        while(curr!=null){
            Node copy = m.get(curr); // node varaible just used for wiring 
            copy.next = m.get(curr.next);
            copy.random = m.get(curr.random);
            curr = curr.next; //used for looping through L list 
        }

        return m.get(head);
    }
}
