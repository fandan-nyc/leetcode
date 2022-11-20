class Solution:
    def preorder(self, root):
        if not root:
            return []
        def helper(node):
            res.append(node.val)
            for node in node.children:
                if not node:
                    helper(node)
        res = []
        helper(root)
        return res

