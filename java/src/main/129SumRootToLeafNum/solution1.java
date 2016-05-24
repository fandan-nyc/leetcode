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
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> store = new ArrayList<Integer>();
        helper(root, store, 0);
        int result = 0;
        for(int i = 0; i < store.size();i++){
            result += store.get(i);
        }
        return result;
        
    }
    
    private void helper(TreeNode node, List<Integer> store, int parent){
        parent = parent*10+node.val;
        if(node.left == null && node.right == null){
            store.add(parent);
             return;
        }
        if( node.left != null){
            helper(node.left,store, parent);
        }
        if(node.right !=null ){
            helper(node.right, store, parent);
        }
    }
}
