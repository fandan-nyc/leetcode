class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        if not nums:
            return False
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            # Avoid duplicate by increment 1
            while left + 1 < right and nums[left] == nums[right]:
                left += 1
            # Compare with left pointer value
            # Case 1:  nums[left] <= target < midV -> target lie in the left subarray
            # Case 2:  midV < target <= nums[right] -> target lies in the right subarray

            mid = left + (right - left) // 2
            midV = nums[mid]
            if midV == target:
                return True       
            elif midV >= nums[left]:
                if target >= nums[left] and target < midV:
                    right = mid
                else:
                    left = mid
            else:
                if target <= nums[right] and target > midV:
                    left = mid
                else:
                    right = mid
        if nums[left] == target:
            return True
        if nums[right] == target:
            return True
        return False
                
