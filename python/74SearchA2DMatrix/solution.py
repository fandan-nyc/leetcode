class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix:
            return False
        m = len(matrix)
        n = len(matrix[0])
        left = 0
        right = m * n - 1
        while left + 1 < right:
            mid = left + (right - left) // 2
            midV = matrix[mid // n][mid % n]
            if midV == target:
                return True
            elif midV < target:
                left = mid
            else:
                right = mid
        if matrix[left // n][left % n] == target or matrix[right // n][right % n] == target:
            return True
        return False
            
