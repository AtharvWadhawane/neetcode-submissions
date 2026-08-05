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
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode front = curr.next; //save next reference
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){ //only one node present
            head = null;
            return head;
        }
        
        //Reverse the LL
        ListNode revhead = reverse(head);

        if(n == 1){
            ListNode finhead = reverse(revhead.next);
            return finhead;
        }
        //Delete the Nth node
        ListNode revcurr = revhead;

        for(int i=0;i<n-2;i++){
            revcurr = revcurr.next;
        }
        if(revcurr.next != null){
            revcurr.next = revcurr.next.next;
        }

        ListNode finalhead = reverse(revhead);

        return finalhead;
    }
}
