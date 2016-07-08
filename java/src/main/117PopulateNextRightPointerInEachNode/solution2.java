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
            return;
        }
        TreeLinkNode nextLineStart = root;
        root.next = null;
        while(nextLineStart != null){
            TreeLinkNode firstNode  = null;
            TreeLinkNode prev = null;
            // get the first Node next Line
            TreeLinkNode curr = nextLineStart;
            while(curr != null){
                if(firstNode == null){
                    if(curr.left != null){
                       firstNode = curr.left;
                    }else{
                        firstNode = curr.right;
                    }
                }
                if(prev == null){
                    prev = curr.left;
                    if(prev == null){
                        prev = curr.right;
                    }else if(curr.right != null){
                        prev.next= curr.right;
                        prev = prev.next;
                    }
                }
                else {
                    if(curr.left != null){
                        prev.next= curr.left;
                        prev = curr.left;
                    }
                    if(curr.right != null){
                        prev.next = curr.right;
                        prev = curr.right;
                    }
                }
                curr = curr.next;
            }
            nextLineStart = firstNode;
        }
        return ;
        
    }
}
