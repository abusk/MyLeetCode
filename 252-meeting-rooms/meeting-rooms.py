class Solution:
    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if len(intervals) == 0:
            return True
        s_v = sorted(intervals, key=lambda x: x[0])
        prv = s_v[0]
        for i in range(1, len(s_v)):
            nxt = s_v[i]
            if prv[1] > nxt[0]:
                return False
            prv = nxt
        return True
            
        
        