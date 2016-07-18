/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for(int i = 1; i <=k; i++){
            if(tail ==  null){
                return head;
            }
            tail = tail.next;
        }
        ListNode rest = reverseKGroup(tail,k);
        ListNode result = rest;
        while(k > 0){
            ListNode next = head.next;
            head.next = result; 
            result = head;
            head = next;
            k--;
        }
        return result;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode result = null;
        while(head != null){
            ListNode next = head.next;
            head.next = result;
            result = head;
            head = head.next;
        }
        return result;
    }
}
