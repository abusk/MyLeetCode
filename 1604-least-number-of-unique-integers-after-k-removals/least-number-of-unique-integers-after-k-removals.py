class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        count = collections.Counter(arr)
        sorted_items = sorted(count.items(), key=lambda x: x[1], reverse= False)
        c  = 0
        for ke, va in sorted_items:
            if k > 0:
                k -= va 
                if k < 0:
                    c += 1
            else:
                c += 1
        return c
            
            
        