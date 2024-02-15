class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        @cache
        def dp(i, j):
            if i == len(s):
                return True
            if j == len(t) and i < len(s):
                return False
            if s[i] == t[j]:
                return dp(i+1, j+1)
            return dp(i, j+1)
        return dp(0, 0)
        