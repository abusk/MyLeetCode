class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        @cache
        def dp(am):
            if am < 0:
                return -1
            if am == 0:
                return 0
            mc = float('inf')
            for c in coins:
                res = dp(am - c)
                if res != -1:
                    mc = min(mc, res+1)
            return mc if mc != float('inf') else -1
        
        return dp(amount)