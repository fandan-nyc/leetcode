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
        # Find Middle, reverse, connect

        slow, prev = self.FindMiddle(head)
        if not prev: return head
        prev.next = None
        reverseHalf = self.reverse(slow)
        res = self.mergeList(head, reverseHalf)
        return res
        
    def FindMiddle(self, head):
        slow = head
        fast = head
        prev= None
        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next
        return slow, prev

    def reverse(self, head):
        prev = None
        while head:
            nextHead = head.next
            head.next = prev
            prev = head
            head = nextHead
        return prev
    
    def mergeList(self, head1, head2):
        dummyHead = ListNode(-1)
        curHead = dummyHead
        while head1 and head2:
            curHead.next = head1
            head1 = head1.next
            curHead = curHead.next
            curHead.next = head2
            head2 = head2.next
            curHead = curHead.next
        if head1:
            curHead.next = head1
        elif head2:
            curHead.next = head2
        return dummyHead.next
