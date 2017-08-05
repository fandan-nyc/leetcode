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
        if(root != null){
            root.next = null;
        }
        while(root != null && root.left != null){
            TreeLinkNode curr = root;
            while(curr != null){
                curr.left.next= curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }else{
                    curr.right.next = null;
                }
                curr= curr.next;
            }
            root = root.left;
        }
    }
}

//
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
        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
