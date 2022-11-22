# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        #Validation
        if not n:
            return -1
        
        l = 0
        r = n
        
        while l + 1 < r:
            mid = l + (r - l) // 2
            if isBadVersion(mid):
                r = mid
            else:
                l = mid
        
        # No need to check left, same with 875.koko eat banana.
        # left is always disqualified becasue we move left to mid if mid is disqualified. 
        #So, we only need to maintain right. 
        #If l is started at 1, then it's incorrect. In this case, we need to check left.
        
        return r
