/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode revert = reverseList(head);
        int carryOver = 1;
        ListNode revertHead = revert;
        while(revertHead.next != null){
            int newValue = (revertHead.val + carryOver)%10;
            carryOver = (revertHead.val + 1) / 10;
            revertHead.val = newValue;
            revertHead = revertHead.next;
        }
        if(revetHead.val == 9 && carryOver == 1){
            revertHead.val = 0;
            revertHead.next = new ListNode(1);
        }else{
            revertHead.val = revertHead.val + carryOver;
        }
        return reverseList(revert);
    }
    
    private ListNode reverseList(ListNode head){
        ListNode tmp = null;
        while(head!= null){
            ListNode curr = head;
            ListNode rest = curr.next;
            curr.next = tmp;
            tmp = curr;
            head = rest;
        }
        return tmp;
        
        
    }
}
