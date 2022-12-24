# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:
    def inorder(self, root:Optional[TreeNode]):
        if not root:
            return
        self.inorder(root.left)
        self.list.append(root.val)
        self.inorder(root.right)
        
    def __init__(self, root: Optional[TreeNode]):
       self.index = 0
       self.list = []
       self.inorder(root)

    def next(self) -> int:
        ans = self.list[self.index]
        self.index += 1
        return ans
        
    def hasNext(self) -> bool:
        if self.index + 1 <= len(self.list):
            return True
        return False
        


# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
