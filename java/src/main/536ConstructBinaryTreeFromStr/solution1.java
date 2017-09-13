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
    public TreeNode str2tree(String s) {
        System.out.println(s);
        if(s == null || s.length() == 0){
            return null;
        }
        int firstParen = s.indexOf("(");
        TreeNode root;
        if(firstParen == -1){
            root = new TreeNode(Integer.valueOf(s));
        }else{
            root = new TreeNode(Integer.valueOf(s.substring(0, firstParen)));
            int left = 1;
            int pos = firstParen;
            while(left != 0){
                pos++;
                if(s.charAt(pos) == ')'){
                    left --;
                }else if(s.charAt(pos) == '('){
                    left ++;
                }
            }
            root.left = str2tree(s.substring(firstParen +1, pos));
            if(pos != s.length()-1)
                root.right =  str2tree(s.substring(pos+2, s.length()-1));
        }
        return root;
    }                       
}
