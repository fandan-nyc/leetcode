tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        Stack<TreeNode> nodes =  new Stack<TreeNode>(); 
        Stack<Integer> subSum = new Stack<Integer>();
        nodes.push(root);
        subSum.push(sum - root.val);
        while(!nodes.isEmpty()){
            TreeNode tmp = nodes.pop();
            int tmpSum = subSum.pop();
            if(tmpSum == 0 && tmp.left == null && tmp.right == null){
                return true;
            }else {
                if(tmp.left != null) {
                    nodes.push(tmp.left);
                    subSum.push(tmpSum - tmp.left.val);
                }
                if(tmp.right != null){
                    nodes.push(tmp.right);
                    subSum.push(tmpSum - tmp.right.val);
                }
            }
        }
        return false;
    }
}
