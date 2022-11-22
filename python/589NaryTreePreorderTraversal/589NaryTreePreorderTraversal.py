class Solution:
    def preorder(self, root):
        if not root:
            return []
        res = []
        self.preorder_traversal(root, res)
        return res
    
    def preorder_traversal(self, node,res):
        res.append(node.val)
        for node in node.children:
            if not node:
                self.preorder_traversal(node, res)
        return res


