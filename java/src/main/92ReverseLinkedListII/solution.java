/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode mPrevious = dummy; 
        while(m > 1){
            mPrevious = mPrevious.next;
            m--;
        }
        ListNode nNode = dummy;
        while(n > 0){
            nNode = nNode.next;
            n--;
        }
        ListNode mNode = mPrevious.next;
        ListNode nNext = nNode.next;
        nNode.next = null;
        mPrevious.next = reverse(mNode);
        mNode.next = nNext;
        return dummy.next;
    }
    
    private ListNode reverse(ListNode n){
        ListNode result  = null; 
        while(n != null){
            ListNode next = n.next; 
            n.next = result;
            result = n;
            n = next;
        }
        return result;
    }
}
