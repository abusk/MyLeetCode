class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        l = len(nums)
        i = 0
        j = 0
        s = 0
        while j < len(nums):
            s += nums[j]
            if s>= target:
                break
            j += 1
        if j == l:
            return 0
        mx = j - i + 1
        while j < len(nums) and i<=j:
            s -= nums[i]
            i += 1
            if j < l -1 and s < target:
                j += 1
                s += nums[j]
            
            if s >= target:
                d = j - i + 1
                if d < mx:
                    mx = d
        return mx
            
        
        