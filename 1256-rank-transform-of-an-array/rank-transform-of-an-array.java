class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int r = 1;
        for(int i = 0; i<copy.length; i++) {
            int key = copy[i];
            if (!map.containsKey(key)) {
                map.put(copy[i], r++);
            }   
        }
        int [] ans = new int[arr.length];
        int i =0;
        for(int a : arr) {
            ans[i++] = map.get(a);
        }
        return ans;
    }
}