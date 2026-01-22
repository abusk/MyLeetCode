// class Solution {
//     int MOD = 1000000007;
//     public int alternatingXOR(int[] nums, int target1, int target2) {
//         Map<Integer, Integer>[] memo1 = new HashMap<>();
//         Map<Integer, Integer> memo2 = new HashMap<>();
//         return dp(nums, 1, true, nums[0], target1, target2, memo1, memo2);
//     }
//     public int dp(int[] nums, int i, boolean f, int xor, int target1, int target2, Map<Integer, Integer>[] memo1, Map<Integer, Integer>[] memo2) {
//         if(i >= nums.length) {
//             if(f && xor == target1) {
//                 return 1;
//             } else if(!f && xor == target2) {
//                 return 1;
//             }
//             return 0;
//         }

//         if(f) {
//             if(memo1.containsKey(i)) {
//                 return memo1.get(i);
//             }
//             int res = 0;
//             if(xor == target1) {
//                 res = dp(nums, i+1, !f, nums[i], target1, target2, memo1, memo2);
//             }
//             res += dp(nums, i+1, f, xor^nums[i], target1, target2, memo1, memo2);
//             res = res % MOD; 
//             memo1.put(i, res);
//             return res;
//         } else {
//             if(memo2.containsKey(i)) {
//                 return memo2.get(i);
//             }
//             int res = 0;
//             if(xor == target2) {
//                 res = dp(nums, i+1, !f, nums[i], target1, target2, memo1, memo2);
//             }
//             res += dp(nums, i+1, f, xor^nums[i], target1, target2, memo1, memo2);
//             res = res % MOD; 
//             memo2.put(i, res);
//             return res;
//         }
//     }
// }

class Solution {
    public static int mod=1000000007;
    public long f(int pos,int curr,boolean flag,int t1,int t2,int[]nums, HashMap<Integer,Long>[] T, HashMap<Integer,Long>[] F){
        if(pos>=nums.length){
            if(flag && curr==t1)return 1;
            else if(!flag && curr==t2)return 1;
            return 0;
        }

        else if(flag && T[pos].containsKey(curr))return T[pos].get(curr);

        else if(!flag && F[pos].containsKey(curr))return F[pos].get(curr);

        if(flag){
            long ans=0;

            if(curr==t1)ans=f(pos+1,nums[pos],false,t1,t2,nums,T,F);
            ans%=mod;

            ans+=f(pos+1,nums[pos]^curr,flag,t1,t2,nums,T,F);
            ans%=mod;

            T[pos].put(curr,ans);

            return ans;
        }else{
            long ans=0;
            if(curr==t2)ans=f(pos+1,nums[pos],true,t1,t2,nums,T,F);
            ans%=mod;

            ans+=f(pos+1,nums[pos]^curr,flag,t1,t2,nums,T,F);
            ans%=mod;

            F[pos].put(curr,ans);

            return ans;
        }
    }
    public int alternatingXOR(int[] nums, int target1, int target2) {
        HashMap<Integer,Long>[] T=new HashMap[nums.length];
        HashMap<Integer,Long>[]F=new HashMap[nums.length];

        for(int i=0;i<nums.length;i++){T[i]=new HashMap();F[i]=new HashMap();}

        long answer=f(1,nums[0],true,target1,target2,nums,T,F);
        answer%=mod;

        return (int)answer;
    }
}