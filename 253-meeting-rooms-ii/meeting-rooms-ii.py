class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        sv = sorted(intervals, key= lambda x: x[0])
        mhp = []
        c = 1
        fst = sv[0]
        heapq.heappush(mhp, fst[1])
        for i in range(1, len(sv)):
            nxt = sv[i]
            if nxt[0] < mhp[0]:
                heapq.heappush(mhp, nxt[1])
            else:
                heapq.heappop(mhp)
                heapq.heappush(mhp, nxt[1])
            if c < len(mhp):
                c = len(mhp)
        return c
            
            
        