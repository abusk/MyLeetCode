class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = {}
        for s in strs:
            s1 = ''.join(sorted(s))
            if s1 in dic:
                dic[s1].append(s)
            else:
                dic[s1] = [s]
        return list(dic.values())
            
        
                
        