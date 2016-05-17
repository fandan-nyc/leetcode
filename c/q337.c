/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
int rob(struct TreeNode* root) {
    if(!root){
        return 0;
    }
    int sum1 = 0;
    if(root->left){
        sum1 += (rob(root->left->left) + rob(root->left->right));
    }
    if(root->right){
        sum1 += ( rob(root->right->left) + rob(root->right->right));
    }
    sum1 += (root->val);
    int sum2 = rob(root->left) + rob(root->right);
    return sum1 > sum2 ? sum1: sum2;
}
