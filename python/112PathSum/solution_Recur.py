# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        #Recur
        res = self.traverse(root, 0, targetSum)
        return res

    def traverse(self, root, curSum, targetSum):
        if not root:
            return False
        curSum += root.val
        if not root.left and not root.right:
            return curSum == targetSum
        return self.traverse(root.left, curSum, targetSum) or self.traverse(root.right, curSum, targetSum)
