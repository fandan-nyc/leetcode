# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
            
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        dummyHead = ListNode(-1,head)
        prev = dummyHead
        cur = head
        for i in range(0,left-1):
            prev = cur
            cur = cur.next

        p = prev
        next = cur.next
        for i in range(left,right+1):
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
        
        p.next.next = next
        p.next = prev

        return dummyHead.next




