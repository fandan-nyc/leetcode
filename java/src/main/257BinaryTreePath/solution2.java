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
        return helper(root, new HashMap<TreeNode, List<String>>());
    }
    
    private List<String> helper(TreeNode root, Map<TreeNode, List<String>> store){
        if(root.left == null && root.right == null){
            store.put(root, Arrays.asList(root.val+""));
        }else{
            List<String> result = new ArrayList<>();
            if(root.left != null)
                copyPath(result, root.val, helper(root.left, store));
            if(root.right != null)
                copyPath(result, root.val, helper(root.right, store));
            store.put(root, result);
        }
        return store.get(root);
    }
    
    private void copyPath(List<String> result, int rootVal, List<String> input){
        for(String i: input){
            result.add(rootVal + "->" + i);
        }
    }
}
