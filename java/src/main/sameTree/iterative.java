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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueForP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueForQ = new LinkedList<TreeNode>();
        queueForP.add(p);
        queueForQ.add(q);
        while(!queueForP.isEmpty() && !queueForQ.isEmpty()){
            TreeNode pNode = queueForP.remove();
            TreeNode qNode = queueForQ.remove();
            if(pNode == null && qNode == null){
                continue;
            }else if( pNode == null || qNode == null){
                return false;
            }else{
                if(pNode.val != qNode.val){
                    return false;
                }else{
                    queueForP.add(pNode.left);
                    queueForP.add(pNode.right);
                    queueForQ.add(qNode.left);
                    queueForQ.add(qNode.right);
                }
            }
        }
        return true;
    }
}

