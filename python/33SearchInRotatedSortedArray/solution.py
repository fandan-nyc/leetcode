class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        left = 0
        right = len(nums) - 1
        while left + 1 < right:
            mid = left + (right - left) // 2
            midV = nums[mid]
            if midV == target:
                return mid
            if midV > nums[left]:
                if midV > target and target >= nums[left]:
                    right = mid
                else:
                    left = mid
            else:
                if midV < target and target <= nums[right]:
                    left = mid
                else:
                    right = mid
        if nums[left] == target:
            return left
        if nums[right] == target:
            return right
        return -1
