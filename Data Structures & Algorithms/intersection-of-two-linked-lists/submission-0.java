/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //Length-based Approach 
public class Solution {
    public int length(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
        if(headA == null || headB == null) return null;
        
        int lenA = length(headA);
        int lenB = length(headB);

        int diff = Math.abs(lenA-lenB);

        ListNode tempa = headA;
        ListNode tempb = headB;

        if(lenA>lenB){
            while(diff-->0){
                tempa = tempa.next;
            }
        }
        else{ 
            while(diff-->0){
                tempb = tempb.next;
            }
        }
         while(tempa!=null && tempb!=null){
                if(tempa == tempb)return tempa;
                tempa = tempa.next;
                tempb = tempb.next;
            }
        return null;
    }
}