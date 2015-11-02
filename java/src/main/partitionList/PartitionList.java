/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode small =  new ListNode(0);
        ListNode smallTmp = small;
        ListNode large = new ListNode(0);
        ListNode largeTmp = large ;
        ListNode tmp = head ;
        while(head !=null)
        {
            tmp = head.next;
            head.next = null;
            if(head.val < x)
            {
                smallTmp.next = head;
                smallTmp = smallTmp.next;
            }
            else 
            {
                largeTmp.next = head ;
                largeTmp = largeTmp.next;
            }
            head = tmp ;
        }
        smallTmp.next = large.next;
        return small.next;
    }
}
