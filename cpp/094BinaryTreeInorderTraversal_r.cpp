/*
  File Name: 094BinaryTreeInorderTraversal.cpp
  Xiaolong Zhang

  Question:
  Given a binary tree, return the inorder 
  traversal of its nodes' values.

  For example:
  Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,3,2].

  Note: Recursive solution is trivial, 
  could you do it iteratively?

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
    void recursing(TreeNode* root, vector<int>& res){
        if(root!=NULL){
            recursing(root->left, res);
            res.push_back(root->val);
            recursing(root->right,res);
            
        }
    }
    vector<int> inorderTraversal(TreeNode* root) {    
        vector<int>res;
        recursing(root, res);
        return res;        
    }
};