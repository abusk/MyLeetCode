class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        l = len(nums)
        if l == 1:
            return 0
        for i in range(l):
            if i == 0 and nums[i] > nums[i+1]:
                return i
            if i == l-1 and nums[i] > nums[i-1]:
                return i
            if nums[i] > nums[i-1] and nums[i] > nums[i+1]:
                return i
            
                
        