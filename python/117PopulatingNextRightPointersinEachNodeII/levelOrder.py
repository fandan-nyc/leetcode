# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        if not root:
            return
        node = root
        queue = deque([node])
        while queue:
            size = length(queue)
            for i in range(size):
                r = queue.popleft()
                if i < size -1:
                    r.next = queue[0]
                if r.left:
                    queue.append(root.left)
                if r.right:
                    queue.append(root.right)
        return root
