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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        Map<Integer, List<Integer>> nodePos = new HashMap<>();
        bfs(root, nodePos);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: nodePos.keySet()){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = min; i <= max ;i++){
            if(nodePos.containsKey(i)){
                res.add(nodePos.get(i));
            }
        }
        return res;
    }
    
    private void bfs(TreeNode root, Map<Integer, List<Integer>> nodePos){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> pos = new LinkedList<>();
        pos.add(0);
        while(queue.isEmpty() == false){
            TreeNode curr = queue.remove();
            int currPos = pos.remove();
            nodePos.putIfAbsent(currPos, new ArrayList<Integer>());
            nodePos.get(currPos).add(curr.val);
            if(curr.left != null){
                queue.add(curr.left);
                pos.add(currPos-1);
            }
             if(curr.right != null){
                queue.add(curr.right);
                pos.add(currPos+1);
            }
        }
    }
}

