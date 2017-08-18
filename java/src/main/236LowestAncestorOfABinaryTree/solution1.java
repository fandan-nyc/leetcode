/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }else if(p == null){
            return q;
        }else if(q == null){
            return p;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! (parent.containsKey(p) && parent.containsKey(q))){
            TreeNode tmp = queue.remove();
            if(tmp.left != null){
                parent.put(tmp.left, tmp);
                queue.add(tmp.left);
            }
            if(tmp.right != null){
                parent.put(tmp.right, tmp);
                queue.add(tmp.right);
            }
        }
        Set<TreeNode> path = new HashSet<TreeNode>();
        while(p != null){
            path.add(p);
            p = parent.get(p);
        }
        while(q != null){
            if(path.contains(q)){
                return q;
            }
            q = parent.get(q);
        }
        return null;
    }
}
