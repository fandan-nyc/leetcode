# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        def helper(node):
            if node:
                yield node
                yield from helper(node.left)
                yield from helper(node.right)
        if original is None:
            return None
        return [x[1] for x in zip(helper(original), helper(cloned)) if x[0] == target][0] 
