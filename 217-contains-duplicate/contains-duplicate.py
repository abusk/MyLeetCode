class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        c = collections.Counter(nums)
        return max(c.values()) > 1
        