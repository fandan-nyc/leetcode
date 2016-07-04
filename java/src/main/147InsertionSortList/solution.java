/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head; 
        ListNode dummyHead = result; 
        ListNode previous = result;
        ListNode curr = result.next;
        while(curr != null){
            ListNode toSwapPrevious = dummyHead;
            ListNode toSwap = toSwapPrevious.next;
            while(toSwap.val < curr.val){
                toSwap = toSwap.next; 
                toSwapPrevious = toSwapPrevious.next;
            }
            if(toSwap == curr){
                curr = curr.next;
                previous = previous.next;
            }else{
                previous.next = curr.next;
                toSwapPrevious.next = curr;
                curr.next = toSwap;
                curr = previous.next;
            }
        }
        return result.next;
    }
}
