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
        // morris traversal 
        List<Integer> result = new ArrayList<Integer>();
        TreeNode curr = root; 
        TreeNode pre = null;
        while(curr != null)
        {
            result.add(curr.val);
            if(curr.left == null)
            {
                curr = curr.right ;
            }
            else
            {
                pre = curr.left;
                while( pre.right != curr.right && pre.right != null )
                {
                    pre = pre.right;
                }
                if(pre.right == null)
                {
                    pre.right = curr.right;
                    curr = curr.left;
                }
                else
                {
                    pre.right = null;
                    result.add(pre.val);
                    curr = curr.right;
                }
            }
        }
        return result ; 
    }
}
