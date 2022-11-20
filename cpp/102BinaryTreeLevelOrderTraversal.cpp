/*
    file name: 102BinaryTreeLevelOrderTraversal.cpp
    Sitong Che
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root)
        {
            return ans;
        }

        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty())
        {
            queue<TreeNode*> qq;
            vector<int> tmp;
            while(!q.empty())
            {
                TreeNode* cur = q.front();
                q.pop();
                tmp.push_back(cur->val);
                if(cur->left)
                {
                    qq.push(cur->left);
                }

                if(cur->right)
                {
                    qq.push(cur->right);
                }
            }

            ans.push_back(tmp);
            swap(q, qq);

        }
        
        return ans;
    }
};