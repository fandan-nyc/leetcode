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
    public List<Integer> inorderTraversal(TreeNode root) {
        // morris traversal 
        TreeNode curr = root; 
        TreeNode pre = null; 
        List<Integer> result  =  new ArrayList<Integer>();
        while(curr != null)
        {
            if(curr.left == null)
            {
                result.add(curr.val);
                curr = curr.right;
            }
            else
            {
                pre =  curr.left;
                while(pre.right != null && pre.right != curr)
                {
                    pre = pre.right ;
                }
                if(pre.right == null)
                {
                    pre.right = curr;
                    curr = curr.left;
                }
                else
                {
                    pre.right  = null;
                    result.add(curr.val);
                    curr= curr.right;
                }
            }
        }
        return result ;
        
    }
}
