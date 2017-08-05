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
    public int findBottomLeftValue(TreeNode root) {
        //bfs 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode tn = queue.remove();
                res = tn.val;
                if(tn.right != null)
                    queue.add(tn.right);
                if(tn.left != null)
                    queue.add(tn.left);
                size--;
            }
        }
        return res;
    }
}
