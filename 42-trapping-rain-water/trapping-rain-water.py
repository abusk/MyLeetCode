class Solution:
    def trap(self, height: List[int]) -> int:
        i = 0
        j = len(height) -1
        res = 0
        lmax = 0
        rmax = 0
        while i<=j:
            if height[i] < height[j]:
                if height[i] >= lmax:
                    lmax = height[i]
                else:
                    res += (lmax - height[i])
                i+=1
            else:
                if height[j] >= rmax:
                    rmax = height[j]
                else:
                    res += (rmax - height[j])
                j -=1
        return res
            
            
        