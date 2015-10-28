/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head; 
        }
        ListNode result = reverseList(head.next);
        ListNode tmp = result;
        while(tmp.next !=null)
        {
            tmp= tmp.next;
        }
        head.next = null;
        tmp.next = head; 
        return result;
    }
}
