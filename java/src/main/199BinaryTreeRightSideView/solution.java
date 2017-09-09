tion for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while(deque.isEmpty() == false){
            int size = deque.size();
            res.add(deque.peekLast().val);
            while(size > 0){
                TreeNode tmp = deque.removeFirst();
                if(tmp.left != null){
                    deque.add(tmp.left);
                }
                if(tmp.right != null){
                    deque.add(tmp.right);
                }
                size --;
            } 
        }
        return res;
    }
}
