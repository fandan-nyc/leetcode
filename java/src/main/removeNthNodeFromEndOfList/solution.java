/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        else if( n <=0)
            return head;
        ListNode result = new ListNode(0);
        result.next = head;
        int count = n;
        ListNode first = result;
        while( first != null && count-- > 0){
            first = first.next;
        }
        if(count > 0){
            return head;
        }
        ListNode second = result;
        while(first.next != null)
        {
            second =  second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return result.next;
        
    }
}
