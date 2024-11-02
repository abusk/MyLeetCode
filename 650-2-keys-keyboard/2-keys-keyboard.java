class Solution {
    public int minSteps(int n) {
        if(n == 1) {
            return 0;
        }
        if(isPrime(n)) {
            return n;
        }

        List<Integer> factors = getFacrors(n);
        Map<Integer, Integer> map = new HashMap<>();
        for(int f : factors) {
            map.put(f, map.getOrDefault(f, 0)+1);
        }
        int ans = 0;
        for(var entry : map.entrySet()) {
            ans += entry.getKey()*entry.getValue();
        }
        return ans;
    }
    private List<Integer> getFacrors(int n) {
        List<Integer> allFactors = new ArrayList<>();
        for(int i = 2; i<=n; i++) {
            while(n % i == 0) {
                allFactors.add(i);
                n = n /i;
            }
        }
        return allFactors;
    }
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}