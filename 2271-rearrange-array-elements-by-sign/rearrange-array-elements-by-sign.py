class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        r = [0] * len(nums)
        i, j = 0, 1
        for num in nums:
            if num > 0:
                r[i] = num
                i += 2
            else:
                r[j] = num
                j += 2
        return r
            
        
            
            
        
            
            
        