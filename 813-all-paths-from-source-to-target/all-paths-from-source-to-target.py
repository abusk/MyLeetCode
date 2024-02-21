class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res = []
        n = len(graph)-1
        def findPath(i, path):
            if i == n:
                path.append(i)
                res.append(path[:])
                return
            path.append(i)
            gl = graph[i]
            for gn in gl:
                findPath(gn, path)
                path.pop()
            return
        findPath(0, [])
        return res
            
            
        
            
        
        