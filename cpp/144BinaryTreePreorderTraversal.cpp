/*
  File Name: 144BinaryTreePreorderTraversal.cpp
  Xiaolong Zhang

  Given a binary tree, return the preorder 
  traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].
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
    vector<int> preorderTraversal(TreeNode* root){
        stack<TreeNode*> myStack = stack<TreeNode*>();
        vector<int> res = vector<int>();
        myStack.push(root);
        while(myStack.size() > 0){
            TreeNode* cRoot = myStack.top();
            myStack.pop();
            if(cRoot != NULL){
                res.push_back(cRoot->val);
                myStack.push(cRoot->right);
                myStack.push(cRoot->left);
            }
        }
        return res;
    }
};