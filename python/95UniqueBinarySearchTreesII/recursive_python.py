# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generate(self, start: int, end: int) -> List[Optional[TreeNode]]:
        ans = []
        if start > end:
            return [None]

        for i in range(start, end+1):
            leftList = self.generate(start, i-1)
            rightList = self.generate(i+1, end)
            for left in leftList:
                for right in rightList:
                    root = TreeNode(i)
                    root.left = left
                    root.right = right
                    ans.append(root)

        return ans
        

    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        return self.generate(1, n)
