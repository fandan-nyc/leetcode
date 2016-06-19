/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // cheating way: to list 
        if(head == null){
            return null;
        }
        List<Integer> result = new ArrayList<Integer>();
        while(head != null){
            result.add(head.val);
            head = head.next ; 
        }
        return helper(result, 0, result.size()-1);
    }
    
    private TreeNode helper(List<Integer> store, int start, int end){
        if(start == end){
            return new TreeNode(store.get(start));
        } else if( start > end){
            return null;
        } else{
            int middle = start + (end -start)/2;
            TreeNode tmp = new TreeNode(store.get(middle));
            tmp.left  = helper(store, start, middle -1);
            tmp.right = helper(store, middle+1, end);
            return tmp;
        }
    }
}
