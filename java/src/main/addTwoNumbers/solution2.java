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
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int carryOver = 0; 
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while(l1 != null && l2 != null){
            dummy.next = new ListNode((l1.val + l2.val + carryOver)%10);
            carryOver = (l1.val + l2.val + carryOver)/10;
            l1 = l1.next; 
            l2 = l2.next;
            dummy = dummy.next;
        }
        while(l1 != null){
            dummy.next = new ListNode((l1.val + carryOver)%10);
            carryOver = ( l1.val + carryOver)/10;
            l1 = l1.next;
            dummy = dummy.next;
        }
        while(l2 != null){
            dummy.next = new ListNode((l2.val + carryOver)%10);
            carryOver = ( l2.val + carryOver)/10;
            l2 = l2.next;
            dummy = dummy.next;
        }
        if(carryOver !=0){
            dummy.next = new ListNode(carryOver);
        }
        return head.next;
    }
}
