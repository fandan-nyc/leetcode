/*
  File Name: 144BinaryTreePreorderTraversal_r.cpp
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
    void recursion(TreeNode* root, vector<int>& res){
      if(root == NULL)
        return;
      else{
        res.push_back(root->val);
        recursion(root->left,res);
        recursion(root->right,res);
      }
    }
    vector<int> res;
    recursion(root,res);
    return res;
  }
};