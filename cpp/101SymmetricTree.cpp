/*
    file name: 101SymmetricTree.cpp
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
    bool recur(TreeNode* left, TreeNode* right){
        if(left == nullptr && right == nullptr)
            return true;
        else{
            if(left != nullptr && right!= nullptr){
                if(left->val == right->val)
                    return recur(left->right, right->left) && recur(left->left, right->right);
                else
                    return false;
            }
            else
                return false;
        }
    }
    bool isSymmetric(TreeNode* root) {
        if(root == nullptr)
            return true;
        else
            return recur(root->left, root->right);
    }
};