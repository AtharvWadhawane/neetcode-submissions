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
// Approach : Priority Queue 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        //add all heads to our pq
        for(ListNode n : lists){
            if(n!=null) pq.add(n);
        }

        ListNode dummy = new ListNode(0);
        ListNode t = dummy;

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            t.next = min;
            t = t.next;

            if(min.next!=null){
                pq.add(min.next);
            }
        }
        return dummy.next;
    }
}
