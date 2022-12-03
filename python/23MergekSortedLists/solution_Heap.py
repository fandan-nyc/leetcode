# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # Heap
        if not lists:
            return None
        dummyHead = ListNode(-1)
        curHead = dummyHead
        heap = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
        while heap:
            curVal, i = heapq.heappop(heap)
            curHead.next = ListNode(curVal)
            curHead = curHead.next
            lists[i] = lists[i].next
            if lists[i]:
                heapq.heappush(heap, (lists[i].val, i))
        return dummyHead.next

        ################
        # Brutal Force
        # if not lists:
        #     return None
        # dummyHead = ListNode(-1)
        # curHead = dummyHead
        # l = []
        # for i in lists:
        #     while i:
        #         l.append(i.val)
        #         i = i.next
        # for j in sorted(l):
        #     curHead.next = ListNode(j)
        #     curHead = curHead.next
        # return dummyHead.next
