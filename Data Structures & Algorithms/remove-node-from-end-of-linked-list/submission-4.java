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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sloth = head;
        ListNode cheetah = head;

        for(int i=0;i<n;i++){
            cheetah = cheetah.next;
        }
        if(cheetah == null) return head.next; //remove first element

        while(cheetah.next!=null){
            sloth = sloth.next;
            cheetah = cheetah.next;
        }
        sloth.next = sloth.next.next;

        return head;
    }
}
