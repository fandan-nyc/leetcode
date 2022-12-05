# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        #Iter
        if not root:
            return False
        stack = []
        stack.append((root, 0))
        while stack:
            curNode, curSum = stack.pop()
            if not curNode.left and not curNode.right:
                if curSum + curNode.val == targetSum:
                    return True 
            if curNode.right:
                stack.append((curNode.right, curSum + curNode.val))
            if curNode.left:
                stack.append((curNode.left, curSum + curNode.val))
        return False
