class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        if not piles:
            return -1
        l = 0
        r = max(piles)
        while l + 1 < r:
            mid = l + (r - l) // 2
            hour = 0
            for pile in piles:
                hour += math.ceil(pile / mid)
            
            if hour <= h:
                r = mid
            else:
                l = mid
        # No need to check left because left starts with 0 which means left should not be considered in this question. 
        #As we checked every midpoint, left will only moves to the disqualified points that we already checked
        #Therefore, we can directly return right. 
        return r
                
    
