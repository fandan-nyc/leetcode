# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:

        #########
        #Very similar to #111, max -> min, -math.inf -> math.inf
        #Iter DFS
        # stack = []
        # if not root:
        #     return 0
        # else:
        #     stack.append((root, 1))
        # res = -math.inf
        
        # while stack:
        #     curNode,curDepth = stack.pop()
        #     if not curNode.left and not curNode.right:
        #         res = max(curDepth, res)
        #     if curNode.left:
        #         stack.append((curNode.left, curDepth + 1))
        #     if curNode.right:
        #         stack.append((curNode.right, curDepth + 1))
        # return res

        # pop() the last element is O(1), pop(0) the first element is O(n) since the whole list needs to be shifted. 

        #Iter BFS
        q = []
        #Validation
        if not root:
            return 0
        else:
            q.append((root, 1))
        
        res = -math.inf
        while q:
            curNode, curDepth = q.pop(0)
            if not curNode.left and not curNode.right:
                res = max(res, curDepth)
            if curNode.left:
                q.append((curNode.left, curDepth + 1))
            if curNode.right:
                q.append((curNode.right, curDepth + 1))

        return res
