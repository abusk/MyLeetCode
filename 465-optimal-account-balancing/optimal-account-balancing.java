class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
        }
        List<Integer> allv = new ArrayList<>(map.values());
        List<Integer> negatives = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        for(int v : allv) {
            if(v < 0) {
                negatives.add(v);
            } else if(v > 0) {
                positives.add(v);
            }
        }
        return recu(negatives, positives);
    }
    public int recu(List<Integer> negatives, List<Integer> positives) {
        if(negatives.isEmpty() && positives.isEmpty()) {
            return 0;
        }
        int neg = negatives.get(0);
        int count = Integer.MAX_VALUE;
        for(int i = 0; i<positives.size(); i++) {
            List<Integer> negativesCopy = new ArrayList<>(negatives);
            List<Integer> positivesCopy = new ArrayList<>(positives);
            negativesCopy.remove(0);
            positivesCopy.remove(i);
            int p = positives.get(i);
            if(p > -neg) {
                positivesCopy.add(p+neg);
            } else if(p < -neg){
                negativesCopy.add(p+neg);
            }
            count = Math.min(count, recu(negativesCopy, positivesCopy));
        }
        return count+1;
    }
}