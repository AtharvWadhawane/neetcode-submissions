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
    public void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;

        while(prev != end){
            ListNode front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }
    }
    public ListNode getKthPosi(ListNode curr, int k){
        while(curr!=null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevgroupend = dummy;

        while(true){

            ListNode kthposi = getKthPosi(prevgroupend,k);
            if(kthposi == null) break;

            ListNode startgroup = prevgroupend.next;
            ListNode nextgroupstart = kthposi.next;

            reverse(startgroup,kthposi);

            prevgroupend.next = kthposi;
            startgroup.next = nextgroupstart;

            prevgroupend = startgroup;
        }
        return dummy.next;
    }
}
