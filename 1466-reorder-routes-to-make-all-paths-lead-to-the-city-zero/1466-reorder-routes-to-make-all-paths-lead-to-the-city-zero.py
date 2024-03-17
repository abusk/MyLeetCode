class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        adj = collections.defaultdict(set)
        for u, v in connections:
            adj[u].add((v, 1))
            adj[v].add((u, 0))
        
        vi = set()
        def dfs(node, c):
            if node in vi:
                return c
            vi.add(node)
            for nei, is_connect in adj[node]:
                if nei not in vi:
                    c += is_connect
                    c = dfs(nei, c)
            return c
        
        return dfs(0, 0)
# class Solution:
#     def minReorder(self, n: int, connections: List[List[int]]) -> int:
#         dt = defaultdict(list)
#         for a,b in connections:
#             dt[a].append((b,True))
#             dt[b].append((a,False))
#         ans = 0
#         q = [0]
#         vis = set()
#         while(q):
#             node = q.pop()
#             vis.add(node)
#             for nd,st in dt[node]:
#                 if nd not in vis:
#                     q.append(nd)
#                     if st: ans+=1
#         return ans
        