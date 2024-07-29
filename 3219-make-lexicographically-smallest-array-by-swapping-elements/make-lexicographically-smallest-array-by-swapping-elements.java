class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        
        int[] copy = Arrays.copyOf(nums, n);
        Arrays.sort(copy);
        Queue<Integer> q = new LinkedList<>();
        q.offer(copy[0]);
        map.put(copy[0], q);

        for(int i=1; i<n; i++) {
            if (copy[i]-copy[i-1]<=limit) {
                q = map.get(copy[i-1]);
            } else {
                q = new LinkedList<>();
            }

            q.offer(copy[i]);
            map.put(copy[i], q);
        }
        
        for (int i=0; i<n; i++) {
            int num = nums[i];
            
            q = map.get(num);
            nums[i] = q.poll();
        }
        
        return nums;
    }
}