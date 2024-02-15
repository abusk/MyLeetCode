class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        ps =[0] * len(nums)
        nums = sorted(nums)
        ps[0] = nums[0]
        for i in range(1, len(nums)):
            ps[i] = ps[i-1]+nums[i]
        for j in range(len(nums)-2, 0, -1):
            rn = nums[j+1]
            if rn < ps[j]:
                return ps[j+1]
        return -1
            
            
            
        
        