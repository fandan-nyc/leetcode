# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        if not inorder:
            return []
        indexmap = {val:index for index, val in enumerate(inorder)}
        root = self.constructTree(0, len(inorder) - 1, postorder, indexmap)
        return root
        
    def constructTree(self, curLeftIndex, curRightIndex, postorder, indexmap):
        # Can't be ">=" so the bottom of the tree can be proceeded. 
        if curLeftIndex > curRightIndex:
            return None
        val = postorder.pop()
        root = TreeNode(val)
        index = indexmap[val]

        # Because the question provided postorder, so to construct the tree, we need to reverse the order.
        # Postorder: left -> right -> root
        # So reversed would be: root -> right_subtree -> left_subtree 
        root.right = self.constructTree(index + 1, curRightIndex, postorder, indexmap)
        root.left = self.constructTree(curLeftIndex, index - 1, postorder, indexmap)
        return root
