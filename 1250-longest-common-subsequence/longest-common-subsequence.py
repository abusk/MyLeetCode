class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        @cache
        def dp(i, j):
            if i == m or j == n:
                return 0
            if text1[i] == text2[j]:
                return dp(i+1, j+1) + 1
            else:
                return max(dp(i+1, j), dp(i, j+1))
        m,n = len(text1), len(text2)
        return dp(0, 0)
        