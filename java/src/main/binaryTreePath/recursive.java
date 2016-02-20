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
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<String>();
        }
        if(root.left == null && root.right == null){
            return Arrays.asList(root.val+ "");
        }
        List<String> result = new ArrayList<String>(); 
        for(String i:binaryTreePaths(root.left)){
            result.add(root.val + "->" + i);
        }
        for(String i:binaryTreePaths(root.right)){
            result.add(root.val + "->" + i);
        }
        return result;
    }
}
