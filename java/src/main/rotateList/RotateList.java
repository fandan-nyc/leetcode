/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
        {
            return head;
        }
        int count = 0; 
        ListNode fast = head ; 
        while(fast != null)
        {
            count += 1;
            fast = fast.next ;
        }
        k = k % count;
        if(k == 0)
        {
            return head;
        }
        ListNode slow = head; 
        fast = head; 
        while(k> 0)
        {
            fast = fast.next;
            k--;
        }
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head; 
        ListNode result  = slow.next;
        slow.next= null;
        return result;
        
    }
}
