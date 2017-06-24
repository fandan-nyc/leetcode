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
    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.add(t);
        String result = "";
        while( !stack.isEmpty()){
             t = stack.peek();
            if(visited.contains(t)){
                result += ")";
                stack.pop();
            }else{
                result += "(" + t.val;
                visited.add(stack.peek());
                if(t.left == null && t.right != null){
                    result += "()";
                }
                if(t.right != null){
                    stack.push(t.right);
                }
                if(t.left != null){
                    stack.push(t.left);
                }
               
            }
        }
        return result.substring(1, result.length() - 1);

    }
}
