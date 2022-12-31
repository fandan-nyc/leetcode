class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k:int] -> int:
        if not root:
            return 0
        stack = []
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            k -=1
            if k ==0:
                return root.val
            root = root.right


