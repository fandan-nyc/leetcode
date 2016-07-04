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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean forward = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while(size > 0){
                TreeNode tmpNode = queue.poll();
                if(tmpNode.left != null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    queue.add(tmpNode.right);
                }
                if(forward){
                    tmp.add(tmpNode.val);
                }else{
                    tmp.add(0, tmpNode.val);
                }
                size --;
            }
            forward = forward ^ true;
            result.add(new ArrayList<Integer>(tmp));
        }
        return result;
    }
}
