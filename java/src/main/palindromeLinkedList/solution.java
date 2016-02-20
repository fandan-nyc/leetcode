/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head; 
        ListNode fast = head; 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        ListNode reversedSecondPart = reverse(slow);
        while(reversedSecondPart != null){
            if(head.val != reversedSecondPart.val){
                return false;
            }
            head = head.next;
            reversedSecondPart = reversedSecondPart.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode x){
       ListNode prev = null; 
       ListNode next = null; 
       while(x != null){
           next = x.next;
           x.next = prev; 
           prev = x ; 
           x = next;
       }
       return prev;
    }
}
