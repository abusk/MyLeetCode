class Solution:
    def backtrack(self, start, target, count, c_arr, ans):
        if sum(c_arr) == target and len(c_arr) == count:
            ans.append(c_arr[:])
            return
        for i in range(start, 10):
            if len(c_arr) < count and sum(c_arr) + i <= target:
                c_arr.append(i)
                self.backtrack(i+1, target, count, c_arr, ans)
                c_arr.pop()
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        ans = []
        self.backtrack(1, n, k, [], ans)
        return ans
        