/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while(fast != null && slow !=null && fast != slow){
            if(fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast ==null){
            return null;
        }
        while(head != slow){
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}
