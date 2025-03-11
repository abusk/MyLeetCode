class Solution {
    public static List<List<String>> ans = new ArrayList<>();
    public static List<List<String>> wordSquares(String[] words) {
        ans.clear();
        Map<String, List<String>> map = new HashMap<>();
        int len = words.length;
        int wl = words[0].length();
        for(int i = 1; i<wl; i++) {
            for(String w : words) {
                String pref = w.substring(0, i);
                List<String> lst = map.getOrDefault(pref, new ArrayList<>());
                lst.add(w);
                map.put(pref, lst);
            }
        }

        for(String w : words) {
            List<String> res = new ArrayList<>();
            res.add(w);
            backtrack(w, 1, map, res);
        }
        return ans;
    }
    public static void backtrack(String word, int i, Map<String, List<String>> map, List<String> res) {
        if(res.size()== word.length()) {
            ans.add(new ArrayList<>(res));
            return;
        }
        if(i >= word.length()) {
            return;
        }
        String pref = nextPrefix(res, i, word);
        List<String> nwords = map.getOrDefault(pref, new ArrayList<>());
        if(nwords.isEmpty()) {
            return;
        }
        for(String next : map.get(pref)) {
            List<String> nextRes = new ArrayList<>(res);
            nextRes.add(next);
            backtrack(word, i+1, map, nextRes);
        }
    }

    public static String nextPrefix(List<String> res, int i, String word) {
        StringBuilder sb = new StringBuilder();
        if(i >= word.length()) {
            return null;
        }
        for(String rs : res) {
            sb.append(rs.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String [] words = {"abat","baba","atan","atal"};
        List<List<String>>  ans = wordSquares(words);
        System.out.println("a");
    }
}