class Solution:
    def climbStairs(self, n: int) -> int:
        @cache
        def dp(i):
            if i <=2:
                return i
            return dp(i-1) + dp(i-2)
        return dp(n)
        