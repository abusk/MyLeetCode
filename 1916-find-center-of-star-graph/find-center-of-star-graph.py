class Solution:
    def findCenter(self, edges: List[List[int]]) -> int:
        dc = defaultdict(list)
        for edge in edges:
            if edge[0] in dc:
                dc[edge[0]].append(edge[1])
            else:
                dc[edge[0]] = [edge[1]]
            if edge[1] in dc:
                dc[edge[1]].append(edge[0])
            else:
                dc[edge[1]] = [edge[0]]
        mx = 0
        r = None
        for k, v in dc.items():
            if len(v) > mx:
                mx = len(v)
                r = k
        return r
        