class Solution:
    def lowestCommonAncestor(self, root:'TreeNode', p: 'TreeNode', q:
            'TreeNode') -> 'TreeNode':
        if not root:
            return
        return self.lca(root, p, q)
    
    def lca(self, root, p, q):
        if not root:
            return 
        if root==p or root==q:
            return root
        left = self.lca(root.left, p,q)
        right = self.lca(root.right, p, q)
        if left and right:
            return root
        if not left:
            return right
        if not right:
            return left
