class Solution:
    def findMin(self, nums: List[int]) -> int:
        if not nums:
            return -1
        left = 0
        right = len(nums) - 1
        # We only care two situations:
        # If the array is rotated, the min value should next to largest value
        # If the array is not rotated, the min value is the first value
        if nums[0] < nums[-1]:
            return nums[0]
        else:
            while left + 1 < right:
                mid = left + (right - left) // 2
                midV = nums[mid]
                if midV > nums[mid + 1]:
                    return nums[mid + 1]
                if midV < nums[mid - 1]:
                    return nums[mid]
                if midV > nums[0]:
                    left = mid
                else:
                    right = mid
        return min(nums[left], nums[right])
