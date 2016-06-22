/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head; 
        ListNode fast = head.next.next;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p2= sortList(slow.next);
        slow.next = null;
        ListNode p1 = sortList(head); 
        return merge(p1,p2);
    }
    
    private ListNode merge(ListNode a, ListNode b){
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(a != null && b  != null){
            if(a.val < b.val){
                tmp.next =a; 
                a=a.next;
            } else {
                tmp.next =b; 
                b=b.next;
            }
            tmp= tmp.next;
        }
       tmp.next = a==null ? b: a;
       return head.next;
    }
}
