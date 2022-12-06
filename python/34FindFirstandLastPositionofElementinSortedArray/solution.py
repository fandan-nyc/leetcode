class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
	# This question is a example of left <= right is better sometimes compared to left + 1 < right
	# left <= right will eventually land in one point, so no need for an extra check. 
	# For this question, checking left and right is tricky IMO.
        if not nums:
            return [-1, -1]
        
        leftRes = self.binarySearchFindLeft(nums, target)
        rightRes = self.binarySearchFindRight(nums, target)
        if leftRes == -1:
            return [-1, -1]
            
        return [leftRes, rightRes]

    def binarySearchFindLeft(self, nums, target):
        left = 0
        right = len(nums) - 1
        leftRes = -1
        while left <= right:
            mid = left + (right - left) // 2
            midV = nums[mid]
            if midV == target:
                leftRes = mid
                right = mid - 1
            elif midV < target:
                left = mid + 1
            else:
                right = mid - 1
        return leftRes

    def binarySearchFindRight(self, nums, target):
        left = 0
        right = len(nums) - 1
        rightRes = -1
        while left <= right:
            mid = left + (right - left) // 2
            midV = nums[mid]
            if midV == target:
                rightRes = mid
                left = mid + 1
            elif midV < target:
                left = mid + 1
            else:
                right = mid - 1
        return rightRes
            
