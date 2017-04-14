/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode headATmp = headA;
        ListNode headBTmp = headB;
        while(headATmp != null && headBTmp != null){
            headATmp = headATmp.next;
            headBTmp = headBTmp.next;
        }
        int counter = 0;
        while(headBTmp != null){
            headBTmp = headBTmp.next;
            headB = headB.next;
            
        }
        while(headATmp != null){
            headATmp = headATmp.next;
            headA = headA.next;
        }
        while(headA != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
