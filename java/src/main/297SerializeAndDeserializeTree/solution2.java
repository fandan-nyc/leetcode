/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty()== false){
            TreeNode tmp = queue.remove();
            if(tmp == null){
                res.append("X,");
            }else{
                res.append(tmp.val + ",");
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        String rootStr = queue.remove();
        if(rootStr.equals("X")){
            return null;
        }
        TreeNode res = new TreeNode(Integer.valueOf(rootStr));
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(res);
        while(nodes.isEmpty() == false){
            TreeNode curr = nodes.remove();
            String leftStr = queue.remove();
            String rightStr = queue.remove();
            if(!leftStr.equals("X")){
                curr.left = new TreeNode(Integer.valueOf(leftStr));
                nodes.add(curr.left);
            }
            if(!rightStr.equals("X")){
                curr.right = new TreeNode(Integer.valueOf(rightStr));
                nodes.add(curr.right);
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
