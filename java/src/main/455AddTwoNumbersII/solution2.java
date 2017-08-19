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
        Stack<Integer> l1stack = new Stack<>();
        Stack<Integer> l2stack = new Stack<>();
        while(l1 != null){
            l1stack.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            l2stack.push(l2.val);
            l2 = l2.next;
        }
        int carryOver = 0;
        ListNode dummy = null;
        while(l1stack.isEmpty() == false || l2stack.isEmpty() == false ){
            int a = l1stack.isEmpty() ? 0: l1stack.pop();
            int b = l2stack.isEmpty() ? 0: l2stack.pop();
            int tmp = a + b + carryOver;
            ListNode curr = new ListNode(tmp%10);
            curr.next = dummy;
            dummy = curr;
            carryOver = tmp/10;
        }
        if(carryOver != 0){
            ListNode curr = new ListNode(carryOver);
            curr.next = dummy;
            return curr;
        }
        return dummy;

    }
}
