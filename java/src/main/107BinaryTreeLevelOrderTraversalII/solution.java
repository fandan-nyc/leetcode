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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> counts = new ArrayList<List<Integer>>();
        visit(root, counts, 0);
        Collections.reverse(counts);
        return counts;
    }

    public void visit(TreeNode node, List<List<Integer>> counts, int level){
        if(node == null)
            return;
        if(counts.size() < level+1)
            counts.add(new ArrayList<Integer>());
        counts.get(level).add(node.val);

        visit(node.left, counts, level+1);
        visit(node.right, counts, level+1);
    }
}
