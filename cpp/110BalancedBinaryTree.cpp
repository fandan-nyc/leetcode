/*
    110BalancedBinaryTree.cpp
    Xiaolong Zhang

*/


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int depthBal(TreeNode* root){
        if(root == nullptr)
            return 0;
        int left = depthBal(root->left);
        int right = depthBal(root->right);
        if(left == -1 || right == -1)
            return -1;
        if(left-right>1 || right-left>1)
            return -1;
        return max(right, left) + 1;
    }
    bool isBalanced(TreeNode* root) {
        if(root == nullptr)
            return true;
        if(depthBal(root) == -1)
            return false;
        return true;
       
            
    }
};