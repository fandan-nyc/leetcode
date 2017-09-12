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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null ){
            return 0;
        }
        Node node = new Node(root, 0);
        Deque<Node> queue = new LinkedList<>();
        queue.add(node);
        int maxWidth = 0;
        while(queue.isEmpty() == false){
            int size = queue.size();
            int left = queue.peekFirst().pos;
            int right = queue.peekLast().pos;
            maxWidth = Math.max(maxWidth, right - left);
            while(size > 0){
                Node tmp = queue.remove();
                TreeNode tmpNode = tmp.node;
                int pos = tmp.pos;
                if(tmpNode.left != null){
                    queue.add(new Node(tmpNode.left, pos*2));
                }
                if(tmpNode.right != null){
                    queue.add(new Node(tmpNode.right, pos*2+1));
                }
                size -- ;
            }
        }
        return maxWidth +1;
    }
}

class Node {
    public TreeNode node; 
    public int pos ; 
    Node(TreeNode node, int pos){
        this.node = node;
        this.pos = pos;
    }
}
