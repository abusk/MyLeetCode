// class Solution {
//     public List<Boolean> getResults(int[][] queries) {
//         List<Integer> lst = new ArrayList<>();
//         lst.add(0);
//         List<Boolean> ans = new ArrayList<>();
//         for(int[] q : queries) {
//             if(q[0] == 1) {
//                 lst.add(q[1]);
//                 lst.sort((a,b) -> a -b);
//             } else {
//                 int start = q[1];
//                 int size = q[2];
//                 boolean f = false;
//                 for(int i = lst.size()-1; i>=0; i--) {
//                     while (start < lst.get(i)) {
//                         i--;
//                     }
//                     if(start >= lst.get(i)) {
//                         if(start - lst.get(i) >= size) {
//                             f = true;
//                             break;
//                         }
//                     }
//                     start = lst.get(i);
//                 }
//                 ans.add(f);
//             }
//         }
//         return ans;
//     }
//     public int getIndex(List<Integer> lst, int target) {
//         if(lst.getLast() <= target) {
//             return lst.size() -1;
//         }
//     }
// }

class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> blocks = new TreeSet<>();
        List<Boolean> res = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            int x = queries[i][1];
            if(queries[i][0] == 1){
                Integer lastBlock = blocks.lower(x);
                if(lastBlock == null)
                    map.put(x, x);
                else
                    map.put(x, Math.max(x - lastBlock, map.get(lastBlock)));

                int lastIndex = x;
                for(int index: blocks.tailSet(x)){
                    int prevSize = map.get(index);
                    int newSize = Math.max(index - lastIndex, map.get(lastIndex));
                    if(newSize == prevSize) break;
                    map.put(index, newSize);
                    lastIndex = index;
                }
                blocks.add(x);
            } else {
                int sz = queries[i][2];
                if(x < sz){
                    res.add(false);
                    continue;
                }
                Integer lastBlock = blocks.floor(x);
                if(lastBlock == null)
                    res.add(true);
                else {
                    if(map.get(lastBlock) >= sz || x - lastBlock >= sz)
                        res.add(true);
                    else
                        res.add(false);
                }
            }
        }
        return res;
    }
}