class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int prev = 0;
        int ans = 0;
        for(int i = s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            if(map.get(ch) < prev) {
                ans -= map.get(ch);
            } else {
                ans += map.get(ch);
            }
            prev = map.get(ch);
        }
        return ans;
    }
}