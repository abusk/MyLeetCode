class Solution:
    def divisorGame(self, n: int) -> bool:
        @cache
        def dp(n):
            if n ==1:
                return False
            for x in range(1, n):
                if n %x == 0 and not dp(n-x):
                    return True
            return False
        return dp(n)
        