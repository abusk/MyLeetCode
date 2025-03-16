class Solution {
    public static long repairCars(int[] ranks, int cars) {
        int maxR = 1;
        for(int r : ranks) {
            maxR = Math.max(maxR, r);
        }
        long maxTime = maxR * (long)cars * cars;
        return bs(ranks, cars, 1, maxTime);
    }
    public static long bs(int[] ranks, int cars, long s, long e) {
        while (s <= e) {
            long mid = (s + e) /2;
            if(ifPossible(ranks, cars, mid)) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return s;
    }
    public static boolean ifPossible(int[] ranks, int cars, long time) {
        if(cars <= 0) {
            return true;
        }
        for(int r : ranks) {
            long nn = time / r;
            int sq = (int) Math.sqrt(nn);
            cars -= sq;
            if (cars <= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] ranks = {4,2,3,1};
        System.out.println(repairCars(ranks, 10));
    }
}