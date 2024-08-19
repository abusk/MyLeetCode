// class Solution {
//     public long findMaximumNumber(long k, int x) {
//         int num = 1;
//         int sum = 0;
//         while (true) {
//             int price = (int) getPrice(num, x);
//             if (sum + price <= k) {
//                 sum += price;
//             } else {
//                 break;
//             }
//             num++;
//         }
//         return num - 1;
//     }

//     public long getPrice(long num, int x) {
//         long price = 0;
//         while (num != 0) {
//             int xthBit = (int) ((1L << (x - 1)) & num);
//             if (xthBit > 0) {
//                 price++;
//             }
//             num = num >> x;
//         }
//         return price;
//     }
// }
class Solution {
    long getNumSetBit(long num, long i){
        long group = (num+1)/i;
        return i*(group/2)+((group%2 == 1) ? (num+1)%i : 0);
    }
    boolean isSafe(long num, long k, int x){
        int i = 0;
        long res = 0;
        long tmp = num;
        while(num > 0){
            num /= 2;
            if((i+1)%x == 0){
                // System.out.println(i+" "+getNumSetBit(tmp, 1<<i));
                res += getNumSetBit(tmp, 1L<<i);
            }
            i++;
        }
        return res <= k;
    }
    public long findMaximumNumber(long k, int x) {
        long res = 0;
        long low = 1, hi = (long)1e15;
        // isSafe(9, k, x);
        while(low <= hi){
            long mid = low+(hi-low)/2;
            if(isSafe(mid, k, x)){
                // System.out.println(mid);
                res = mid;
                low = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return res;
    }
}