class TreeNode:
    def __init__(self, val = 0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def recoverTree(self, root: Optional[TreeNode])->None:
        if not root:
            return
        stack = []
        first = second = pre = None
        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            if pre and pre.val > root.val:
                second = root
                if not first:
                    pre = first
                else:
                    break
            pre = root
            root = root.right
        first.val, second.val = second.val, first.val

