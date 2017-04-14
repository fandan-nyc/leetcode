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
        if(headA== null || headB == null){
            return null;
        }
        int countA = 0;
        int countB = 0;
        ListNode headATmp = headA ; 
        while(headATmp != null){
            countA ++;
            headATmp = headATmp.next;
        }
        ListNode headBTmp = headB ; 
        while(headBTmp != null){
            countB ++;
            headBTmp = headBTmp.next;
        }
        if(countA > countB){
            while(countA != countB){
                countA --;
                headA = headA.next;
            }
        }else{
            while(countA != countB){
                countB --;
                headB = headB.next;
            }
        }
        while(headA != headB){
            headA= headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
