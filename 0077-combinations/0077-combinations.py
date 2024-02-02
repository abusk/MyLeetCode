class Solution:
    def backtrack(self, start:int, n: int, k:int, c_combi:List[int], ans:List[List[int]]):
        if len(c_combi) == k:
            ans.append(c_combi[:])
            return
        for num in range(start, n+1):
            c_combi.append(num)
            self.backtrack(num+1, n, k, c_combi, ans)
            c_combi.pop()    
        
    def combine(self, n: int, k: int) -> List[List[int]]:
        ans = []
        c_combi = []
        self.backtrack(1, n, k, c_combi, ans)
        return ans