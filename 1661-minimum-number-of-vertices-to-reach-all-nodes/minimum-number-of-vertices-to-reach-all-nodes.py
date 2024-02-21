class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        ic = [0]*n
        for edge in edges:
            ic[edge[1]] += 1
        res = []
        for i in range(0, len(ic)):
            if ic[i] == 0:
                res.append(i)
        return res
        