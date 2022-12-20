# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        #Recur
        #If the input head is None -> reutrn head back
        if not head:
            return None
        #If we reach the last node -> return head back
        if not head.next:
            return head
        #Recur goes to the last node
        last = self.reverseList(head.next)
        #This line will be triggered at second last node
        head.next.next = head
        head.next = None
        return last
                
