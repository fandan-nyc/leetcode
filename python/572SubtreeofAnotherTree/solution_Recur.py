# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        #Recur
        if not root:
            return False
        elif self.checkSameTree(root, subRoot):
            return True
        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)

    def checkSameTree(self, root1, root2):
        if not root1 or not root2:
            return root1 == root2
        if root1.val != root2.val:
            return False
        return self.checkSameTree(root1.left, root2.left) and self.checkSameTree(root1.right, root2.right)

