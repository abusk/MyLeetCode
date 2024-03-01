class Solution:
    def maxOperations(self, nums: List[int], k: int) -> int:
        dc = collections.Counter(nums)
        c = 0
        for num in nums:
            if ((num == k-num) and dc[num] > 1) or ((num != k-num) and dc[num] > 0 and dc[k-num] > 0) :
                dc[num] -= 1
                dc[k-num] -= 1
                c+=1
        return c
                
        