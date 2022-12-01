
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        #Validation
        if not root:
            return []
        
        stack = [(root, False)]
        res = []
        
        while stack:
            #Get the last of the stack
            root, visited = stack.pop()
            if root:
                if visited:
                    res.append(root.val)
                else:
                    #stack is reversed order, root is at the bottom of the stack
                    stack.append((root, True))
                    stack.append((root.right, False))
                    stack.append((root.left, False))
                    
        return res
            
