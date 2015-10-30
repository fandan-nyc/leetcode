/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head ; 
        ListNode tmp = fake ; 
        while( tmp.next !=null && tmp.next.next != null)
        {
            ListNode t3 = tmp.next.next.next;
            ListNode t2 = tmp.next.next;
            ListNode t1 = tmp.next;
            tmp.next = t2;
            tmp.next.next = t1;
            tmp.next.next.next = t3;
            tmp = t1;
        }
        return fake.next;
    }
}
