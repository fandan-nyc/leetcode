# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
 	#Iter
        queue = []
        queue.append((p,q))
        while queue:
            p, q = queue.pop(0)
            if not self.check(p,q):
                return False
            if p or q:
                queue.append((p.left, q.left))
                queue.append((p.right, q.right))
        return True

    def check(self,p,q):
        if not p or not q:
            return p == q
        if p.val != q.val:
            return False
        return True
