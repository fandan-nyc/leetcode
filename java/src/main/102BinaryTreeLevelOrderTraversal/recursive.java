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
        List<List<Integer>> count = new ArrayList<List<Integer>>();
        levelOrderHelper(root, count, 0);
        return count;
    }
    
    private void levelOrderHelper(TreeNode root, List<List<Integer>> counter, int level){
        if(root == null){
            return;
        }
        if(counter.size() < level+1 ){
            counter.add(new ArrayList<Integer>());
        }
        counter.get(level).add(root.val);
        levelOrderHelper(root.left, counter, level+1);
        levelOrderHelper(root.right, counter, level+1);
    }
}
