class Solution {
    public static int MOD = 1000000007;
    public static int colorTheGrid(int m, int n) {
        List<String> states = new ArrayList<>();
        generateStates(states, "", m);
        int ans = 0;
        Map<String, Integer> memo = new HashMap<>();
        for(int i = 0; i<states.size(); i++) {
            ans = (ans + dp(states, i, n-1, memo)) % MOD;
        }

        return ans;
    }
    public static int dp(List<String> states, int iState,  int n, Map<String, Integer> memo) {
        if(n == 0) {
            return 1;
        }
        String key = n + ":" + iState;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }
        String prevState = states.get(iState);
        int result = 0;
        for(int i = 0; i<states.size(); i++) {
            if(i == iState) {
                continue;
            }
            String curState = states.get(i);
            if(valid(prevState, curState)) {
                result = (result + dp(states, i, n-1, memo)) % MOD;
            }
        }
        int val = result % MOD;
        memo.put(key, val);
        return val;
    }
    public static boolean valid(String stat1, String state2) {
        for(int i = 0; i<stat1.length(); i++) {
            if(stat1.charAt(i) == state2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void generateStates(List<String> states, String state, int len) {
        if(state.length() == len) {
            states.add(state);
            return;
        }
        StringBuilder sb = new StringBuilder(state);
        for(char ch : "RGB".toCharArray()) {
            if(!state.isEmpty() && state.charAt(state.length()-1) == ch) {
                continue;
            }
            sb.append(ch);
            generateStates(states, sb.toString(), len);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        System.out.println(colorTheGrid(3, 3));
    }
}