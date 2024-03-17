class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        l = len(isConnected)
        vi = [False] * l
        c = 0
        
        def dfs(i):
            vi[i] = True
            for j in range(l):
                if isConnected[i][j] == 1 and not vi[j]:
                    dfs(j)
            return
        
        for i in range(l):
            if not vi[i]:
                c+=1
                dfs(i)
        return c
        