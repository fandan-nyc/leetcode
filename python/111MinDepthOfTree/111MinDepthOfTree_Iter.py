# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        ##############
        #Very similar to #104, max -> min, -math.inf -> math.inf

        # DFS_Iter
        # if not root:
        #     return 0
        # else:
        #     stack = [(root, 1)]
        #     minDepth = math.inf
        
        # while stack:
        #     node, curDepth = stack.pop()
        #     if not node.left and not node.right:
        #         minDepth = min(minDepth, curDepth)
        #     if node.left:
        #         stack.append((node.left, curDepth + 1))
        #     if node.right:
        #         stack.append((node.right, curDepth + 1))
        # return minDepth

        # BFS_Iter
        q = []
        if not root:
            return 0
        else:
            q.append((root, 1))
        res = math.inf

        while q:
            curNode, curDepth = q.pop(0)
            if not curNode.left and not curNode.right:
                res = min(res, curDepth)

            if curNode.left:
                q.append((curNode.left, curDepth + 1))
            if curNode.right:
                q.append((curNode.right, curDepth + 1))

        return res
        




            
            
        
        
        
        

        
