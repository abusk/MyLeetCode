class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        c = collections.Counter(nums)
        m = max(c.values())
        res = 0
        for n in c.values():
            if m == n:
                res += n
        return res
        