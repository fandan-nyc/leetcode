# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPath(self, root:Optional[TreeNode]):
        if not root:
            return 0
        l = 0
        r = 0
        if root.left:
            l = self.maxPath(root.left)
        if root.right:
            r = self.maxPath(root.right)
        self.maxSum = max(self.maxSum, root.val+max(l,r), root.val+l+r)
        return max(0,root.val + max(l,r))

    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return -math.inf
        self.maxSum = -math.inf
        self.maxPath(root)
        return self.maxSum
        