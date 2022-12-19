# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
#class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        left = 0
        leftV = reader.get(left)
        # Since the array is sorted, use the first value and target to find the right bound
        right = abs(target - 1) + abs(leftV)
        
        while left + 1 < right:
            mid = left + (right - left) // 2
            midV = reader.get(mid)
            if midV == target:
                return mid
            elif midV > target:
                right = mid
            else:
                left = mid
        if reader.get(left) == target:
            return left
        elif reader.get(right) == target:
            return right
        else:
            return -1

