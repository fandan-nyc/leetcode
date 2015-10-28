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
        ListNode result = head ;
        if(head == null || head.next == null)
        {
            return result;
        }
        ListNode tmp = head.next;
        result.next=null;
        while(tmp != null)
        {
            ListNode nextStep = tmp.next;
            tmp.next = result;
            result = tmp;
            tmp = nextStep;
        }
        return result;
    }
}
