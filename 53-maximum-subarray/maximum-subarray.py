class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        cur = mx = nums[0]
        for num in nums[1:]:
            cur = max(num, cur+num)
            mx = max(cur, mx)
        return mx