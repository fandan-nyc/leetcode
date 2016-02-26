/*
    file name 107BinaryTreeLevelOrderTravelsalII.cpp
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
    void iter(queue<TreeNode*>& first, queue<TreeNode*>& second, stack<vector<int> >& myStack){
        while(!first.empty() || !second.empty()){
            if(!first.empty()){
                vector<int> layer;
                while(!first.empty()){
                    TreeNode* temp = first.front();
                    first.pop();
                    if(temp->left)
                        second.push(temp->left);
                    if(temp->right)
                        second.push(temp->right);
                    layer.push_back(temp->val);
                }
                myStack.push(layer);
            }
            if(!second.empty()){
                vector<int> layer;
                while(!second.empty()){
                    TreeNode* temp = second.front();
                    second.pop();
                    if(temp->left)
                        first.push(temp->left);
                    if(temp->right)
                        first.push(temp->right);
                    layer.push_back(temp->val);
                }
                myStack.push(layer);
            }
        }
    }
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int> > result;
        stack<vector<int> >myStack;
        if(root == nullptr)
            return result;
        queue<TreeNode*> first;
        queue<TreeNode*> second;
        first.push(root);
        iter(first, second, myStack);
        while(!myStack.empty()){
            result.push_back(myStack.top());
            myStack.pop();
        }
        return result;
    }
};