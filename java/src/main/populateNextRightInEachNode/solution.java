/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return ;
        }
        // assume that it is a perfect binary tree.
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        TreeLinkNode toRight = null;
        while(queue.isEmpty() == false){
            int counter = queue.size(); 
            toRight = null;
            while(counter > 0){
                TreeLinkNode curr = queue.poll();
                curr.next = toRight; 
                toRight = curr;
                counter --;
                if(curr.left != null && curr.right != null){
                     queue.add(curr.right);
                    queue.add(curr.left);
                }
            }
        }
    }
}
