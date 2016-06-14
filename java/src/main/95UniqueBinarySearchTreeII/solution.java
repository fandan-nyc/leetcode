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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int start, int end){
        if(start > end){
            List<TreeNode> result = new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        if(start == end){
            List<TreeNode> result = new ArrayList<TreeNode>();
            TreeNode tmp = new TreeNode(start);
            tmp.left = null;
            tmp.right = null;
            result.add(tmp);
            return result;
        }
        List<TreeNode> result = new ArrayList<TreeNode>();
        List<TreeNode> lefts ;
        List<TreeNode> rights;
        for(int i = start; i <= end;i++){
            lefts =  helper(start,i-1);
            rights = helper(i+1, end);
            for(TreeNode left: lefts){
                for(TreeNode right: rights){
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = left;
                    newNode.right = right;
                    result.add(newNode);
                }
            }
        }
        return result;
    }
}
