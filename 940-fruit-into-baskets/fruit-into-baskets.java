class Solution {
    public static int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < n) {
            int rv = fruits[right];
            map.put(rv, map.getOrDefault(rv, 0) +1);
            while (map.size() > 2) {
                int lv = fruits[left];
                int mc = map.get(lv) - 1;
                if(mc == 0) {
                    map.remove(lv);
                } else {
                    map.put(lv, mc);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
}