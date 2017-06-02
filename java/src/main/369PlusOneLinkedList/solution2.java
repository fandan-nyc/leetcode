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
        int carry = helper(head);
        if(carry == 0){
            return head;
        }
        ListNode result = new ListNode(carry);
        result.next = head;
        return result;
    }
    
    public int helper(ListNode head){
        if(head == null){
            return 1;
        }
        int carryOver = helper(head.next);
        if(carryOver == 0){
            return 0;
        }else{
            int newValue = (head.val + carryOver)% 10; 
            carryOver =  (head.val + carryOver)/10;
            head.val = newValue;
            return carryOver;
        }
    }
}
