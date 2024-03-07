class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        def ew(i, j, n):
            coll = []
            for m in range(n):
                coll.append(grid[m][j])
            if grid[i] == coll:
                return 1
            return 0
        l = len(grid)
        c = 0
        for i in range(l):
            for j in range(l):
                c += ew(i, j, l)
        return c
                    
        