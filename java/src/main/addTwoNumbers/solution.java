/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        ListNode result = new ListNode(0);
        ListNode tmpResult = result;
        while(l1 != null || l2 !=null)
        {
            int tmp = (l1 == null ? 0: l1.val) + (l2==null ? 0:l2.val) + carryOver;
            if(tmp >= 10){
                carryOver = 1;
                tmp = tmp -10;
            }
            else
                carryOver = 0;
            tmpResult.next = new ListNode(tmp);
            tmpResult = tmpResult.next;
            if(l1 != null)
                l1=l1.next;
            if(l2 !=null)
                l2=l2.next;
        }
        if(carryOver == 1)
            tmpResult.next = new ListNode(1);
        return result.next;
    }
}
