# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findPath(self, root:Optional[TreeNode], targetSum:int, path:List[int], ans:List[List[int]]):
        if not root:
            return
        path.append(root.val)
        if root.val == targetSum and (not root.left) and (not root.right):
            ans.append(path.copy())
        self.findPath(root.left, targetSum-root.val, path, ans)
        self.findPath(root.right, targetSum-root.val, path, ans)
        path.pop()
        
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        ans = []
        path = []
        self.findPath(root, targetSum, path, ans)
        return ans
