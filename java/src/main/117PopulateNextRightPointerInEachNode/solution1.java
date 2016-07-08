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
        // use queue
        if(root == null){
            return ;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty() == false){
            int size = queue.size();
            TreeLinkNode prev = null;
            while(size > 0){
                TreeLinkNode curr = queue.poll();
                if(prev != null){
                    prev.next = curr;
                }
                prev = curr;
                size--;
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            prev.next = null;
        }
        return ;
        
    }
}
