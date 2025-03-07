class Solution {
    public static int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();
        boolean [] sieve = getSieve(right);
        for(int i = left; i<=right; i++) {
            if(sieve[i]) {
                primes.add(i);
            }
        }
        primes.sort((a,b) -> a-b);
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        if(primes.size() < 2) {
            return new int[]{-1, -1};
        }
        for(int i = 1; i<primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i-1);
            if(diff < min) {
                min = diff;
                ans[0] = primes.get(i-1);
                ans[1] = primes.get(i);
            }
        }
        return ans;
    }
    public static boolean[] getSieve(int num) {
        boolean[] sieveL = new boolean[num+1];
        Arrays.fill(sieveL, true);
        sieveL[0] = false;
        sieveL[1] = false;
        for(int next = 2; next * next <= num; next++) {
            if(sieveL[next]) {
                for(int mul = next * next; mul <= num; mul += next) {
                    sieveL[mul] = false;
                }
            }
        }
        return sieveL;
    }

    public static void main(String[] args) {
        int[] ans = closestPrimes(4, 6);
        System.out.println(ans[0] +" " + ans[1]);
    }
}