/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0; 
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(l1 != null || l2 != null){
            int first = l1 == null ? 0: l1.val;
            int second = l2 == null? 0: l2.val;
            dummy.next = new ListNode((first + second + carryOver)%10);
            carryOver = (first + second+ carryOver)/10;
            l1 = l1 != null ? l1.next: null; 
            l2 = l2 != null ? l2.next: null;
            dummy = dummy.next;
        }
        if(carryOver !=0){
            dummy.next = new ListNode(carryOver);
        }
        return head.next;
    }
}
