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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
        {
            return result ;
        }
        queue.add(root);
        while( ! queue.isEmpty())
        {
            List<Integer> tmpNum  = new ArrayList<Integer>();
            int len = queue.size();
            while(len >0)
            {
                TreeNode tn = queue.poll();
                tmpNum.add(tn.val);
                len --;
                if(tn.left != null)
                { 
                    queue.add(tn.left);
                }
                if(tn.right != null)
                {
                    queue.add(tn.right);
                }
            }
            result.add(tmpNum);
        }
        return result ; 
        
    }
}
