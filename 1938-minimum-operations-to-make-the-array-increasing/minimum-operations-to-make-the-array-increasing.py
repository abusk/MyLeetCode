class Solution:
    def minOperations(self, nums: List[int]) -> int:
        t = 0
        l = len(nums)
        if l == 1:
            return 0
        for i in range(1, l):
            p = nums[i-1]
            c = nums[i]
            if p >= c:
                t += (p-c) +1
                nums[i] = p+1
        return t
                
            
            
        