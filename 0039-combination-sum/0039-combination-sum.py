class Solution:
    def backtrack(self, i:int, target:int, candidates: List[int], c_arr: List[int], ans: List[List[int]]):
        if sum(c_arr) == target:
            ans.append(c_arr[:])
            return
        for j in range(i, len(candidates)):
            if sum(c_arr) + candidates[j] <= target:
                c_arr.append(candidates[j])
                self.backtrack(j, target, candidates, c_arr, ans)
                c_arr.pop()
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        c_arr = []
        ans = []
        self.backtrack(0, target, candidates, c_arr, ans)
        return ans