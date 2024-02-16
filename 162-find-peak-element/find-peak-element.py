class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        def sp(l, r):
            if l == r:
                return l
            m = (l+r)//2
            if nums[m] > nums[m+1]:
                return sp(l, m)
            return sp(m+1, r)
        return sp(0, len(nums)-1)
        