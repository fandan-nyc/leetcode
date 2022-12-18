# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #Recur
        if not root:
            return []
        global res
        res = []
        self.levelPrinter(root, 0)
        return res

    def levelPrinter(self, root, level):
        prevLevel = len(res)
        #First time to next level
        if prevLevel == level:
            res.append([])
        res[level].append(root.val)

        if root.left:
            self.levelPrinter(root.left, level + 1)
        if root.right:
            self.levelPrinter(root.right, level + 1)
