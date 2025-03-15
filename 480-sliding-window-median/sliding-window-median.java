class Solution {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();
        Map<Integer, Integer> hashTable = new HashMap<>();
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder()); // Max heap
        PriorityQueue<Integer> hi = new PriorityQueue<>(); // Min heap

        int i = 0;

        // Initialize the heaps
        while (i < k) {
            lo.offer(nums[i++]);
        }
        for (int j = 0; j < k / 2; j++) {
            hi.offer(lo.poll());
        }

        while (true) {
            // Get median of current window
            if ((k & 1) == 1) {
                medians.add((double) lo.peek());
            } else {
                medians.add(((double) lo.peek() + (double) hi.peek()) * 0.5);
            }

            if (i >= nums.length) break; // Break if all elements processed

            int outNum = nums[i - k]; // Outgoing element
            int inNum = nums[i++]; // Incoming element
            int balance = 0; // Balance factor

            // Number `outNum` exits window
            balance += (outNum <= lo.peek() ? -1 : 1);
            hashTable.put(outNum, hashTable.getOrDefault(outNum, 0) + 1);

            // Number `inNum` enters window
            if (!lo.isEmpty() && inNum <= lo.peek()) {
                balance++;
                lo.offer(inNum);
            } else {
                balance--;
                hi.offer(inNum);
            }

            // Re-balance heaps
            if (balance < 0) { // `lo` needs more valid elements
                lo.offer(hi.poll());
                balance++;
            }
            if (balance > 0) { // `hi` needs more valid elements
                hi.offer(lo.poll());
                balance--;
            }

            // Remove invalid numbers that should be discarded from heap tops
            while (!lo.isEmpty() && hashTable.getOrDefault(lo.peek(), 0) > 0) {
                hashTable.put(lo.peek(), hashTable.get(lo.peek()) - 1);
                lo.poll();
            }
            while (!hi.isEmpty() && hashTable.getOrDefault(hi.peek(), 0) > 0) {
                hashTable.put(hi.peek(), hashTable.get(hi.peek()) - 1);
                hi.poll();
            }
        }

        // Convert list to array
        return medians.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        double[] ans = medianSlidingWindow(nums, 3);
    }
}