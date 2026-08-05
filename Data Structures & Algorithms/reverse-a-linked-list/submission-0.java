/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode front = null;
        ListNode curr = head;

        while(curr!=null){
            //Save the next address
            front = curr.next;

            //reverse the  current node's pointer
            curr.next = prev;

            //move previous to current node
            prev = curr;

            //move current node to next node 
            curr = front;
        }

    return prev; //last pointer becomes our new head 
    }
}
