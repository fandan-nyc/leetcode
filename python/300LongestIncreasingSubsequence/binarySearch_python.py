class Solution:
    def findLowerBound(self, ans: List[int], target: int) -> int:
        left = 0
        right = len(ans)-1
        while left + 1 < right:
            mid = left + (right - left)//2
            if ans[mid]<=target:
                left = mid
            else:
                right = mid
        if ans[left]>=target:
            return left
        return right

    def lengthOfLIS(self, nums: List[int]) -> int:
        ans = []
        n = len(nums)
        if n == 0:
            return 0
        
        for i in range(n):
            if len(ans)==0 or ans[len(ans)-1] < nums[i]:
                ans.append(nums[i])
            else:
                index = self.findLowerBound(ans, nums[i])
                ans[index] = nums[i]
        
        return len(ans)
