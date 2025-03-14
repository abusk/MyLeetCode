class Solution {
    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int c : candies) {
            sum += c;
        }
        if (sum < k) {
            return 0;
        }
        long d = sum /k;
        
        if (check(candies, k, d)) {
            return (int)d;
        }
        return (int) bs(candies, k, d);
    }

    public static long bs(int[] candies, long k, long d) {
        long s = 1;
        long l = d;
        while (s <= l) {
            long mid = (s+l) /2;
            if(check(candies, k, mid)) {
                s = mid+1;
            } else {
                l = mid -1;
            }
        }
        return l;
    }

    public static boolean check(int[] candies, long k, long d) {
        long count = 0;
        for(int cand : candies) {
            count += (cand / d);
        }
        return  count >= k;
    }

    public static void main(String[] args) {
        int [] cand = {5,8,6};
        System.out.println(maximumCandies(cand, 3));
    }
}