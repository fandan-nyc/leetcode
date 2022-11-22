# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    end = None
    def reverseTopN(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        global end
        if n == 1:
            end = head.next
            return head
        last = self.reverseTopN(head.next, n-1)
        head.next.next = head
        head.next = end
        return last 

    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        if left == 1:
            return self.reverseTopN(head,right)
        else:
            head.next = self.reverseBetween(head.next,left-1,right-1)

        return head




