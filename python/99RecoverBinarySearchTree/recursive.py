class TreeNode:
    def __init__(self, val=0, left = None, right = None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def recoverTree(self, root = Optional[TreeNode]) -> None:
        node = []
        def append_function(seq, node):
            seq.append(node.val)
        def pop_function(seq, node):
            node.val = seq.pop(0)

        def inorder_traversal(root, func):
            if not root:
                return
            inorder_traversal(root.left, func)
            func(node, root)
            inorder_traversal(root.right, func)
        inorder_traversal(root, append_func)
        node.sort()
        inorder_traversal(root, pop_func)

