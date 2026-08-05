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
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null) return h2;
        if(h2 == null) return h1;

        if(h1.val<=h2.val){
            h1.next = merge(h1.next,h2);
            return h1;
        }
        else{
            h2.next = merge(h1,h2.next);
            return h2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) 
        return null;

        if(lists.length == 1) return lists[0];

        if(lists.length == 2) return merge(lists[0],lists[1]);

        ListNode head = lists[0];
        for(int i=1;i<lists.length;i++){
            head = merge(head,lists[i]);
        }
        return head;
        
    }
}
