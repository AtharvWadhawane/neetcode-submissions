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
        if (head == null) return null;

        // Step 1: find length
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // Step 2: if head needs to be deleted
        if (n == size) {
            return head.next;
        }

        // Step 3: go to node before target
        int beforeTarget = size - n;
        ListNode curr = head;

        for (int i = 0; i < beforeTarget - 1; i++) {
            curr = curr.next;
        }

        // Step 4: delete target node
        if (curr.next != null) {
            curr.next = curr.next.next;
        }

        return head;
    }
}
