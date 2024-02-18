class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        c1 = 0
        c2 = 0
        e1 = None
        e2 = None
        
        for num in nums:
            if num == e1:
                c1 += 1
            elif num == e2:
                c2 +=1
            elif c1 == 0:
                e1 = num
                c1 += 1
            elif c2 == 0:
                e2 = num
                c2 += 1
            else:
                c1 -= 1
                c2 -= 1
                
        res = []
        for c in [e1, e2]:
            if nums.count(c) > len(nums)//3:
                res.append(c)
        return res
        
    
        
        
        