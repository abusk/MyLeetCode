class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        fst = snd = float('inf')
        for num in nums:
            if num<=fst:
                fst = num
            elif num <= snd:
                snd = num
            else:
                return True
        return False
        
        
        
        