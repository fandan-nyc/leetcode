# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        # Stack
        if not head:
            return []
        stack = []
        newHead = head
        count = 0
        while newHead:
            stack.append(newHead)
            newHead = newHead.next
            count += 1
        newHead2 = head
        while count >= 0:
            nextHead1 = stack.pop()
            nextHead2 = newHead2.next
            newHead2.next = nextHead1
            count -= 1
            if count == 0:
                break
            nextHead1.next = nextHead2
            if count == 0:
                break
            count -= 1
            newHead2 = nextHead2   
        newHead2.next = None
        return head
