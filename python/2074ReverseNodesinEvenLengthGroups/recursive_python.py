# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    end = None
    def reverseN(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        global end
        if n == 1:
            end = head.next
            return head
        last = self.reverseN(head.next, n-1)
        head.next.next = head
        head.next = end
        return last

    def reverseRest(self, head: Optional[ListNode], length: int, level: int) -> Optional[ListNode]:
        global end
        if not head or not head.next:
            return head

        prev = None
        cur = head
        if length <= 1+level*2:
            if length%2 == 0:
                return self.reverseN(cur,length)
            return head

        length -= 1+level*2
        for i in range(0,1+level*2):
            prev = cur
            cur = cur.next
        
        if length <= 2+level*2:
            if length%2 == 0:
                prev.next = self.reverseN(cur,length)
            return head

        length -= 2+level*2
        last = self.reverseN(cur, 2+level*2)
        prev.next.next = self.reverseRest(end, length, level+1)
        prev.next = last

        return head

        
    def reverseEvenLengthGroups(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head

        cur = head
        end = cur
        length = 0
        while(end):
            end = end.next
            length += 1

        return self.reverseRest(head, length, 0)
        


