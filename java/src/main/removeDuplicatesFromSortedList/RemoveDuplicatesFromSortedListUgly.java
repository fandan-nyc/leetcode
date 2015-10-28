/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null )
        {
            return head;
        }
        ListNode result = head ;
        ListNode tmp = head;
         head =  head.next;
        while(head != null)
        {
            if(tmp.val == head.val)
            {
                tmp.next =head.next;
            }
            else
            {
                tmp = head;
            }
            head = head.next;
        }
        return result;
        
    }
}
