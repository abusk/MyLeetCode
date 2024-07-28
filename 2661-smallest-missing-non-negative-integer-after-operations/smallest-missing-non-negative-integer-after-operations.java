// class Solution {
//     public int findSmallestInteger(int[] nums, int value) {
//         int len = nums.length;
//         Set<Integer> st = new HashSet<>();
//         for(int i = 0; i<len; i++) {
//             addN(st, nums[i], len, value);
//         }
//         int i = 0;
//         for(; i<len; i++) {
//             if(!st.contains(i)) {
//                 return i;
//             }
//         }
//         return i;
//     }
//     public void addN(Set<Integer> st, int num, int len, int value) {
        
//         if(num < 0) {
//             int div = Math.abs(num) / value;
//             num = value * (div +1) + num;
//         }
//         num = num % value;
//         while(num < len) {
//             if(!st.contains(num)){
//                 st.add(num);
//                 break;
//             }
//             num += value;
//         }
//     }
// }

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        
        int vis[]=new int[value];
        for(int it:nums){
            if(it%value<0) vis[(it%value)+value]++;
           else vis[Math.abs(it)%value]++; 
        }
        
        
        int res=0;
        
        while(true){
            
            if(vis[res%value]==0) return res;
            vis[res%value]--;
            res++;
        }
        
        // return -1;
    }
}