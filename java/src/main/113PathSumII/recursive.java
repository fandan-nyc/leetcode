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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null){
            return result;
        }else if(root.left == null && root.right == null && root.val == sum){
            result.add(new ArrayList(Arrays.asList(root.val)));
            return result;
        }
        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        for(List<Integer> i: left){
            i.add(0, root.val);
            result.add(i);
        }
        for(List<Integer> i: right){
            i.add(0, root.val);
            result.add(i);
        }
        return result;
    }
}
