class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        n = len(s)
        if n==0 or k>n:
            return 0
        mp = Counter(s)
        for char, count in mp.items():
            if count<k:
                return max(self.longestSubstring(substr, k) for substr in s.split(char))
        return n
