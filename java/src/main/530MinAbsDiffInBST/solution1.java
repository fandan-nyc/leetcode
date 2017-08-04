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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> t = new ArrayList<Integer>();
        traversal(root, t);
        quickSort(t, 0, t.size()-1);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < t.size(); i++){
            min = Math.min(min, t.get(i) - t.get(i-1));
        }
        return min;
        
    }
    
    private void quickSort(List<Integer> list, int start, int end){
        if(start < end){
            int pi = partition(list, start, end);
            quickSort(list, start, pi-1);
            quickSort(list, pi+1, end);
        }
    }
    
    private int partition(List<Integer>list, int start, int end){
        int pivot = list.get(end);
        int next = start -1;
        for(int i = start; i < end; i++){
            if(list.get(i) < pivot){
                swap(list, i, ++next);
            }
        }
        swap(list, ++next, end);
        return next;
    }
    
    private void swap(List<Integer> input, int a, int b){
        int tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }
    
    private void traversal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        if(node.left != null){
            traversal(node.left, list);
        }
        list.add(node.val);

        if(node.right != null){
            traversal(node.right, list);
        }
    }
}
