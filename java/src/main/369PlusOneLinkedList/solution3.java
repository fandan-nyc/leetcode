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
        // basically, there find the last non-9 digit
        // after that, it is all 9
        // then we change them to zero. 
        ListNode result = new ListNode(0);
        result.next = head; 
        ListNode i = result; 
        ListNode j = result;
        while(j != null){
            if(j.val != 9){
                i = j;
            }
            j = j.next;
        }
        i.val++;
        i = i.next;
        while(i != null){
            i.val = 0 ;
            i = i.next;
        }
        return result.val == 0 ? result.next: result;
        
    }
}
