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
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(head.val-1);
        ListNode dummyHead = dummy;
        ListNode previous = dummyHead;
        ListNode pointer = head;
        while(pointer.next  != null){
            if(pointer.val != pointer.next.val && pointer.val != previous.val){
                dummyHead.next = pointer;
                dummyHead = dummyHead.next;
            }
            previous = pointer;
            pointer =  pointer.next;
        }
        if(pointer.val != previous.val){
            dummyHead.next = pointer;
            dummyHead = dummyHead.next;
        }
        dummyHead.next = null;
        return dummy.next;
    }
}
