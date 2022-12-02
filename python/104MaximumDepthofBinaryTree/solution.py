# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        
        # Recur
        res = self.helper(root)
        return res

    def helper(self, root: Optional[TreeNode]):
        if not root:
            return 0
        return max(self.helper(root.left), self.helper(root.right)) + 1
        
