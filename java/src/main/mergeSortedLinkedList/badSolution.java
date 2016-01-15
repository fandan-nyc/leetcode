/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode result = new ListNode(0);
        mergeTwoListsHelper(l1,l2,result);
        return result.next;
       
    }
    
    private void mergeTwoListsHelper(ListNode l1, ListNode l2, ListNode result)
    {
        if(l1 == null && l2 == null){
            return ;
        }
        if(l1 == null){
            result.next = l2;
            return ;
        }
        else if(l2 == null){
            result.next = l1;
            return ;
        }
        if(l1.val > l2.val){
            result.next = l2;
            l2=l2.next;
        }
        else{
            result.next = l1;
            l1=l1.next;
        }  
        result = result.next;
         mergeTwoListsHelper(l1, l2, result);
    }
}
