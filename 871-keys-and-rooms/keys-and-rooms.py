class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        l = len(rooms)
        vi = [False] * l
        def dfs(i):
            if vi[i]:
                return
            vi[i] = True
            for j in rooms[i]:
                dfs(j)
        dfs(0)
        return all(itm for itm in vi)
                
            
        