/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return ;
        }
        ListNode slow = head; 
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf;
        if(fast == null){// even number
            secondHalf = slow.next;
            slow.next = null;
        }else{ // odd number
            secondHalf = slow.next.next;
            slow.next.next = null;
        }
        secondHalf = reverseList(secondHalf);
        ListNode result = head;
        while(result != null && secondHalf !=null){
            ListNode next = result.next;
            result.next = secondHalf;
            secondHalf = secondHalf.next;
            result.next.next = next;
            result = next;
        }
        return ;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode result = null;
        while(head != null){
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = next;
        }
        return result;
    }
}
