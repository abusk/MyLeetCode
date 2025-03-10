class Solution {
    public static String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        List<String> numbers = List.of("zero", "two", "six", "eight", "three", "seven", "five", "four", "one", "nine");
        Map<String, Integer> mapping = Map.of("zero", 0, "one", 1, "two", 2, "three",3, "four", 4, "five",5, "six", 6, "seven",7,  "eight",8, "nine", 9);
        List<Integer> res = new ArrayList<>();
        for(String num : numbers) {
            while (validate(map, num)) {
                res.add(mapping.get(num));
                update(map, num);
            }
        }
        res.sort((a, b)-> a-b);
        StringBuilder sb = new StringBuilder();
        for(int a : res) {
            sb.append(a);
        }
        return sb.toString();
    }

    public static boolean validate(Map<Character, Integer> map, String num) {
        for (char ch : num.toCharArray()) {
            if(!map.containsKey(ch) || map.get(ch) <= 0) {
                return false;
            }
        }
        return true;
    }
    public static void update(Map<Character, Integer> map, String num) {
        for (char ch : num.toCharArray()) {
            map.put(ch, map.get(ch) -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
}