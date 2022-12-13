# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    prev = None
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if not root:
            return
        self.prev = root
        l = root.left
        r = root.right
        root.left = None
        root.right = l
        self.flatten(l)
        self.prev.right = r
        self.flatten(r)
