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
    public boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        long compare = Long.MIN_VALUE;
        for(int i : result){
            if(compare >= i){
                return false;
            }
            compare = i;
        }
        return true;
    }
    
    private void preorder(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        Stack<TreeNode> data = new Stack<>();
        data.push(root);
        while(data.peek().left != null){
                data.push(data.peek().left);
        }
        while(data.empty()==false){
            result.add(data.peek().val);
            TreeNode tmp = data.pop();
            if(tmp.right != null){
                data.push(tmp.right);
                while(data.peek().left != null){
                    data.push(data.peek().left);
                }
            }
        }
    }
}
