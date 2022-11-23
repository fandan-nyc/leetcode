class Solution:
    def countLessOrEqualThanTarget(self, matrix: List[List[int]], target: int) -> int:
        count = 0
        n=len(matrix)
        j = n-1
        for i in range(n):
            while j>=0 and matrix[i][j]>target:
                j -= 1
            count += j+1
        return count

    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        n = len(matrix)
        if n == 0:
            return -1

        left = matrix[0][0]
        right = matrix[n-1][n-1]
        while left + 1 < right:
            mid = left + (right - left)//2
            if self.countLessOrEqualThanTarget(matrix, mid) < k:
                left = mid
            else:
                right = mid
        if self.countLessOrEqualThanTarget(matrix, left) >= k:
            return left
        return right

                
