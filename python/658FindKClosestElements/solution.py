class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        if not arr:
            return []
        if k == len(arr):
            return arr

        left = 0
        right = len(arr) - k
        # Find the left bound
        # lean the arr to the left by len(arr) - k and our left bound should lie in this range. 
        while left + 1 < right:
            mid = left + (right - left) // 2
            midV = arr[mid]
            if x - midV > arr[mid + k] - x:
                left = mid
            else:
                right = mid
        if x - arr[left] > arr[left + k] - x:
            return arr[right:right + k]
        else:
            return arr[left:left + k]
