class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        cmx = mx = cmn = nums[0]
        for num in nums[1:]:
            tmx = max(num, cmx * num, cmn*num)
            cmn = min(num, cmx * num, cmn*num)
            cmx = tmx
            mx = max(cmx, mx)
        return mx