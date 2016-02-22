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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null)
       {
            result.add(root.val);
            result.addAll(preorderTraversal(root.left));
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }
}

// the solution above is bad too, because using recursive you need to recreate a new result and the cost of memory is huge. 
// try the following one: 
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<Integer>();
        helper(root, list);
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            helper(root.left, list);
            helper(root.right,list);
        }
    }
}
