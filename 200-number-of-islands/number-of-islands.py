class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        c = 0
        m = len(grid)
        n = len(grid[0])
        def makeAdjZero(i, j):
            if i < 0 or i >= m or j < 0 or j >= n:
                return
            if grid[i][j] == "0":
                return
            grid[i][j] = "0"
            makeAdjZero(i, j+1)
            makeAdjZero(i, j-1)
            makeAdjZero(i+1, j)
            makeAdjZero(i-1, j)
            return
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    c += 1
                    makeAdjZero(i, j)
        return c
                
            