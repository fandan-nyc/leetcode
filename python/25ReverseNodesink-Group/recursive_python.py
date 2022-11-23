# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseUntil(self, head: Optional[ListNode], end: ListNode) -> Optional[ListNode]:
        if head.next == end:
            return head
        last = self.reverseUntil(head.next, end)
        head.next.next = head
        head.next = end
        return last

    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        end = head
        for i in range(0,k):
            if not end:
                return head
            end = end.next

        last = self.reverseUntil(head,end)
        head.next = self.reverseKGroup(end,k)
        return last
            

        

        
