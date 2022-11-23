# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverse(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        last = self.reverse(head.next)
        head.next.next = head
        head.next = None
        return last

    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
 
        prev = None
        cur = head
        next = cur.next
        level = 0
        length = 0
        end = cur
        while(end):
            end = end.next
            length += 1

        while(cur):
            if length < 1+level*2:
                if length%2 == 0:
                    prev.next = self.reverse(cur)
                return head

            length -= 1+level*2
            for i in range(0,1+level*2):
                prev = cur
                cur = cur.next
            
            if length < 2+level*2:
                if length%2 == 0:
                    prev.next = self.reverse(cur)
                return head

            length -= 2+level*2
            p = prev
            c = cur
            for i in range(0,2+level*2):
                next = cur.next
                cur.next = prev
                prev = cur
                cur = next
            
            p.next.next = next
            p.next = prev
            prev = c
            level += 1

        return head
        


