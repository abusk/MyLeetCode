class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        d = {}
        d[0] = -1
        ml = 0
        c = 0
        for i in range(len(nums)):
            v = 1 if nums[i] == 1 else -1
            c += v
            if c in d:
                ml = max(ml, i-d[c])
            else:
                d[c] = i
        return ml
            
        