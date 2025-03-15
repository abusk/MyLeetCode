import java.util.Map.Entry;

class Solution {
    private static final int MAX_COUNT = 6;

    public int findMinStep(String board, String hand) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c :hand.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        return findMinStep(board, map, new HashMap<>(), MAX_COUNT);
    }

    private int findMinStep(String board, Map<Character, Integer> freq, Map<String, Integer> cache, int maxDepth) {
        String key = board + "#" + toKey(freq);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (board.isEmpty()) { 
            cache.put(key, 0);
            return 0;
        }
        if (maxDepth <= 0 || looser(board, freq)) {
            cache.put(key, -1);
            return -1;
        }
        int res = MAX_COUNT;
        StringBuilder sb = new StringBuilder(board);
        for (int i = 0; i < sb.length(); i++) {
            for (char c: freq.keySet()) {
                boolean check = board.charAt(i) == c 
                       || (i > 0 && board.charAt(i) == board.charAt(i - 1));
                if (freq.get(c) > 0 && check) {
                    sb.insert(i, c);
                    freq.put(c, freq.get(c) - 1);
                    
                    String newBoard = updateBoard(sb.toString());
                    
                    int temp = findMinStep(newBoard, freq, cache, res == -1 ? maxDepth - 1 : res - 2);
                    if (temp != -1) {
                        res = Math.min(res, temp + 1);
                    }
                    //backtracking
                    sb.deleteCharAt(i);
                    freq.put(c, freq.get(c) + 1);
                }
            }
        }
        res = res >= MAX_COUNT ? -1 : res;
        cache.put(key, res);
        return res;
    }

    private String updateBoard(String board){
        int i = 0;
        int j = 0;
        //System.out.println(board);
        while (i < board.length()) {
            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                return updateBoard(board.substring(0, i) + board.substring(j));
            } else {
                i++;
            }
        }
        return board;
    }

    private String toKey(Map<Character, Integer> freq) {
        String key = "";
        for (Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > 0) {
                key += e.getKey() + "=" + e.getValue();
            }
        }
        return key;
    }

    private boolean looser(String board, Map<Character, Integer> freq) {
        if (!freq.entrySet().stream().anyMatch(e -> e.getValue() > 0)) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : board.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() > 0 && e.getValue() + freq.getOrDefault(e.getKey(), 0) < 3) {
                return true;
            }
        }
        return false;
    }
}


