class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        @cache
        def dp(i, j):
            if j < i:
                return 0
            sc1 = nums[i] + min(dp(i+1, j-1), dp(i+2, j))
            sc2 = nums[j] + min(dp(i, j-2), dp(i+1, j-1))
            return max(sc1, sc2)  
        sc = dp(0, len(nums)-1)
        
        return sc>=(sum(nums)-sc)
        