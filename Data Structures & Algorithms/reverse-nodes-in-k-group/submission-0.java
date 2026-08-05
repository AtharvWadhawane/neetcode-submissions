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

/*
1. put all elements in arraylist
2. reverse k group of elements in arraylist
3. convert arraylist back to  LL and return dummy.next;
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        
        //reverse k  groups
        for(int i=0;i+k<=arr.size();i+=k){
            reverse(arr,i,i+k-1);
        }

        //convert back to ll
        ListNode dummy = new ListNode(0);
        ListNode t = dummy;

        for(int i=0;i<arr.size();i++){
            ListNode x = new ListNode(arr.get(i));
            t.next = x;
            t = t.next;
        }
        return dummy.next;
    }

    public  void reverse(ArrayList<Integer>arr, int a , int b){
        while(a<=b){
            int temp = arr.get(a);
            arr.set(a,arr.get(b));
            arr.set(b,temp);
            a++;
            b--;
        }
    } 
}
