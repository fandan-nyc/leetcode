# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #Iterative
        if not head:
            return None
        prev = None
        while head:
            nextHead = head.next
            head.next = prev
            prev = head
            head = nextHead
        return prev
