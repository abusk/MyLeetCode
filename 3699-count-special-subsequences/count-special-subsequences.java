// class Solution {
//     public long numberOfSubsequences(int[] nums) {
//         Map<String, Long> memo = new HashMap<>();
//         return dp(nums, new ArrayList<>(), 0, memo);
//     }

//     public long dp(int[] nums, List<Integer> idxs, int i, Map<String, Long> memo) {
//         if(idxs.size() == 4) {
//             if(idxs.get(0) * idxs.get(2) == idxs.get(1) * idxs.get(3)) {
//                 return 1;
//             } else {
//                 return 0;
//             }
//         }
//         if(i >= nums.length) {
//             return 0;
//         }

//         String key = i + ":" + idxs.toString();
//         if (memo.containsKey(key)) {
//             return memo.get(key);
//         }

//         List<Integer> copyIdxs = new ArrayList<>(idxs);
//         copyIdxs.add(nums[i]);
//         long res = dp(nums, copyIdxs, i+2, memo) + dp(nums, idxs, i+1, memo);
//         memo.put(key, res);
//         return res;
//     }
// }

class Solution {
    public long numberOfSubsequences(int[] nums) {
          HashMap<Double,Integer>hm=new HashMap<>();
         long ans=0;
         for(int r=3;r<nums.length-2;r++){
            int q=r-2;
            for(int p=0;p<q-1;p++){
                hm.put((1.0*nums[p])/nums[q],hm.getOrDefault((1.0*nums[p])/nums[q],0)+1);
            }
            for(int s=r+2;s<nums.length;s++){
                 ans+=hm.getOrDefault((1.0*nums[s])/nums[r],0);            
            }
         }
         return ans;
    }
}