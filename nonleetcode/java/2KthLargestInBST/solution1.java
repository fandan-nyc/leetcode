package leetcodeTest;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test extends TestCase {

    @Test
    public void test1(){
        TreeSeriDeseri tsd = new TreeSeriDeseri();
        TreeNode tn =tsd.deserialize("1,2,null,null,3,4,null,5,null,null,6,null,null");
        assertEquals(tn.val, 1);
        assertEquals(tn.left.val, 2);
        assertEquals(tn.left.left, null);
        assertEquals(tn.left.right, null);
        assertEquals(tn.right.val, 3);
        assertEquals(tn.right.left.val, 4);
        assertEquals(tn.right.left.right.val, 5);
        assertEquals(tn.right.right.val, 6);
    }

    @Test
    public void test2(){
        TreeSeriDeseri tsd = new TreeSeriDeseri();
        TreeNode tn =tsd.deserialize("10,5,4,null,null,6,null,null,17,15,null,null,18,null,null");
        Solution so = new Solution();
        assertEquals(so.findKthLargest(tn, 1),18);
        assertEquals(so.findKthLargest(tn, 2),17);
        assertEquals(so.findKthLargest(tn, 3),15);
        assertEquals(so.findKthLargest(tn, 4),10);
        assertEquals(so.findKthLargest(tn, 5),6);
        assertEquals(so.findKthLargest(tn, 6),5);
        assertEquals(so.findKthLargest(tn, 7),4);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int i) {
            this.val = i;
        }
    }

    class Solution {
        public int findKthLargest(TreeNode tree, int k) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || tree != null) {
                while (tree != null) {
                    stack.push(tree);
                    tree = tree.right;
                }
                TreeNode curr = stack.pop();
                if (--k == 0) {
                    return curr.val;
                }
                tree = curr.left;
            }
            throw new IllegalArgumentException("k is larger than total number of nodes in tree");
        }
    }

    class TreeSeriDeseri{

        public String serialize(TreeNode node){
            StringBuilder sb = new StringBuilder();
            helper(node, sb);
            return sb.toString();
        }

        private void helper(TreeNode node, StringBuilder sb){
            if(node == null){
                sb.append("null,");
                return;
            }
            sb.append(node.val + ",");
            helper(node.left, sb);
            helper(node.right, sb);
        }

        public TreeNode deserialize(String str){
            String[] strArr = str.split(",");
            Queue<String> queue = new LinkedList<>();
            queue.addAll(Arrays.asList(strArr));
            return deseHelper(queue);
        }

        private TreeNode deseHelper(Queue<String> queue){
            String head = queue.remove();
            if(head.equals("null")){
                return null;
            }
            TreeNode res = new TreeNode(Integer.valueOf(head));
            res.left = deseHelper(queue);
            res.right = deseHelper(queue);
            return res;
        }

    }
}

