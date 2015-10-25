/*
Given a binary tree, return the preorder traversal of its nodes' values.
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
        vector<int> res=vector<int>();
        myStack.push(root);
        while(myStack.size()>0){
            TreeNode* cRoot=myStack.top();
            myStack.pop();
            if(cRoot!=NULL){
                res.push_back(cRoot->val);
                myStack.push(cRoot->right);
                myStack.push(cRoot->left);
            }
        }
        return res;
        
//           if(root==NULL)return;
//            else{
//                res.push_back(root->val);
//                recursion(root->left,res);
//                recursion(root->right,res);
//            }
            
        }
//    vector<int> preorderTraversal(TreeNode* root) {
//        vector<int> res;
        
//       recursion(root,res);
//        return res;
        
//    }
};