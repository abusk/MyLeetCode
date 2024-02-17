class Solution:
    def furthestBuilding(self, heights: List[int], bricks: int, ladders: int) -> int:
        mh = []
        for i in range(len(heights) -1):
            d = heights[i+1] - heights[i]
            if d <= 0 :
                continue
            heapq.heappush(mh, d)
            if len(mh) <= ladders:
                continue
            bricks -= heapq.heappop(mh)
            if bricks<0:
                return i            
        return len(heights) - 1
            