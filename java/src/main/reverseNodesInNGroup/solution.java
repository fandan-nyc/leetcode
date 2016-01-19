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
        if(head == null || head.next == null || k <= 1)
            return head;
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode tail = head;
        ListNode start = head; 
        ListNode then;
        ListNode prev = result;
        while(true){
            for(int i = 1; i <= k; i++){
                if(tail == null){
                    return result.next;
                }
                tail = tail.next;
            }
            for(int i = 1; i <= k-1; i++){
                then = start.next;
                start.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
            prev = start; 
            start = prev.next;
        }
    }
}
