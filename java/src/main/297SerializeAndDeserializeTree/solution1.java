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
        if(root == null){
            return "NULL" + ",";
        }
        String res=  root.val + "," + serialize(root.left) + serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        TreeNode res = deseHelper(queue);
        return res;
    }
    
    private TreeNode deseHelper(Queue<String> queue){
        String root = queue.remove();
        if(root.equals("NULL")){
            return null;
        }
        TreeNode rootNode = new TreeNode(Integer.valueOf(root));
        rootNode.left = deseHelper(queue);
        rootNode.right = deseHelper(queue);
        return rootNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
