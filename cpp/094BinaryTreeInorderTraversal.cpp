/*
Given a binary tree, return the inorder traversal of its nodes' values.
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
//    void recursing(TreeNode* root, vector<int>& res){
//        if(root!=NULL){
//            recursing(root->left, res);
//            res.push_back(root->val);
//            recursing(root->right,res);
//            
//        }
//    }
    vector<int> inorderTraversal(TreeNode* root) {
        stack<TreeNode*> myStack;
        vector<int> res;
        while(root!=NULL || !myStack.empty()){
            if(root!=NULL){
                myStack.push(root);
                root=root->left;
            }
            else{
                root=myStack.top();
                myStack.pop();
                res.push_back(root->val);
                root=root->right;
            }
            
        }
        return res;
        
//        vector<int>res;
//        recursing(root, res);
//        return res;
        
        
    }
};