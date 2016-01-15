/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        return mergeKListsHelper(lists, 0, lists.length-1);
        
    }
    
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
        // assume that lists is not null
        if(start == end)
            return lists[start];
        else{
            int middle = (start + end)/2;
            ListNode left = mergeKListsHelper(lists, start, middle);
            ListNode right = mergeKListsHelper(lists, middle+1, end);
            return mergeTwoSortedLists(left, right);
        }
    }
    
    private ListNode mergeTwoSortedLists(ListNode a, ListNode b){
        if(a == null && b == null)
            return null;
        else if(a == null)
            return b;
        else if( b == null)
            return a;
        if(a.val > b.val){
            b.next = mergeTwoSortedLists(a, b.next);
            return b;
        }else {
            a.next = mergeTwoSortedLists(a.next, b);
            return a;
        }
    }
}
