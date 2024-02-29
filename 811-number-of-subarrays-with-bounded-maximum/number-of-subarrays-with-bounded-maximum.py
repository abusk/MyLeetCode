class Solution:
    def numSubarrayBoundedMax(self, nums: List[int], left: int, right: int) -> int:
        ans = 0
        lastIn, lastEx = -1, -1
        for i in range(len(nums)):
            if nums[i] >= left:
                lastIn = i
            if nums[i] > right:
                lastEx = i
            ans += max(lastIn - lastEx, 0)
        return ans
            
        