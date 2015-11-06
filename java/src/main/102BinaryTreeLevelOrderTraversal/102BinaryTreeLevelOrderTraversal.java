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
        if(root == null)
        {
            return result ;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while( ! stack.isEmpty())
        {
            List<TreeNode> tmp =  new ArrayList<TreeNode>();
            List<Integer> tmpNum  = new ArrayList<Integer>();
            while(! stack.isEmpty())
            {
                TreeNode i = stack.pop();
                tmp.add(i);
                tmpNum.add(i.val);
            }
            result.add(tmpNum);
            for(int i = tmp.size() -1; i >=0 ; i --)
            {
                if(tmp.get(i).right !=null)
                {stack.push(tmp.get(i).right);
                }
                if(tmp.get(i).left != null)
                {
                    stack.push(tmp.get(i).left);
                }
            }
        }
        return result ; 
        
    }
}
