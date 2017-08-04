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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> t = new ArrayList<Integer>();
        traversal(root, t);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < t.size(); i++){
            min = Math.min(min, t.get(i) - t.get(i-1));
        }
        return min;
        
    }
    
    private void traversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        if(node.left != null){
            traversal(node.left, list);
        }
        list.add(node.val);

        if(node.right != null){
            traversal(node.right, list);
        }
    }
}
