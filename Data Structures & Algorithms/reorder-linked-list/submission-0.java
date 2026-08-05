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
    public void reorderList(ListNode head) {
        
        //Find split point i.e. Middle

        ListNode sloth = head, cheetah = head;
        while(cheetah!=null && cheetah.next!=null){
            sloth = sloth.next;
            cheetah = cheetah.next.next;
        }

        //Reverse the second half 
        ListNode prev = null;
        ListNode curr = sloth.next; //start point of second half
        sloth.next = null; // point first half end to null

        while(curr!=null){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
        //now our prev is the start of 2nd LL
        ListNode l1 = head;
        ListNode l2 = prev;
        // prev = prev.next;

        while (l2 != null) {
            ListNode next1 = l1.next;
            ListNode next2 = l2.next;

            l1.next = l2;
            l2.next = next1;

            l1 = next1;
            l2 = next2;}
        //print the whole LL
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
