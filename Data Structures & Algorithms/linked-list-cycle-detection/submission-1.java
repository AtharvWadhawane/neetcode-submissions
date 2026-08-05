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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;

        ListNode sloth = head;
        ListNode cheetah = head;

        while(cheetah!=null && cheetah.next!=null){ //safe to make 2 steps
            sloth = sloth.next;
            cheetah = cheetah.next.next;

            if(sloth==cheetah) return true;
        } 

    return false;
    }
}
