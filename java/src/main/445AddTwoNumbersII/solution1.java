/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Rev = reverseList(l1);
        ListNode l2Rev = reverseList(l2);
        ListNode res = addTwoLists(l1Rev, l2Rev);
        return reverseList(res);
    }
    
    private ListNode addTwoLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carryOver = 0;
        while(a != null || b != null){
            int aInt = a == null ? 0 : a.val;
            int bInt = b == null ? 0 : b.val;
            dummy.next = new ListNode((aInt+bInt+carryOver) % 10);
            dummy = dummy.next;
            carryOver = (aInt+bInt+carryOver)/10;
            a = a ==null ? a : a.next;
            b = b == null ? b: b.next;
        }
        if(carryOver != 0){
            dummy.next = new ListNode(carryOver);
        }
        return head.next;
    }
    
    private ListNode reverseList(ListNode a){
        ListNode res = null;
        while(a != null){
            ListNode next = a.next;
            a.next = res;
            res = a;
            a = next;
        }
        return res;
    }
}
