// class Solution {
//     public int[] exclusiveTime(int n, List<String> logs) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for(int i = 0; i<n; i++) {
//             map.put(i, 0);
//         }
//         List<int[]> logList = new ArrayList<>();
//         for(String log : logs) {
//             String[] sp = log.split("[:]");
//             int [] e = new int[2];
//             e[0] = Integer.parseInt(sp[0].trim());
//             e[1] = Integer.parseInt(sp[2].trim());
//             logList.add(e);
//         }
//         logList.sort((a, b) -> b[1] - a[1]);
//         int last = logList.get(0)[1];
//         int prvId = logList.get(0)[0];
//         for(int[] e: logList) {
//             map.put(prvId, map.get(prvId) + (last - e[1]));
//             last = e[1];
//             prvId = e[0];
//         }
//         int[] ans = new int[n];
//         for(int i = 0; i<n; i++) {
//             ans[i] = map.get(i);
//         }
//         return ans;
//     }
// }

/**
 * Time Complexity: O(N * L) = O(N)
 *
 * Space Complexity: O(N/2) = O(N)
 *
 * N = Length of the input list of logs. L = Average length of each log. This
 * can be considered as constant.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0 || logs == null || logs.size() == 0) {
            return result;
        }

        // This stack will store the function ids
        Deque<Integer> stack = new ArrayDeque<>();
        // Previous time = start/resume time of the previous function
        int prevTime = 0;

        for (String log : logs) {
            String[] logParts = log.split(":");
            int curTime = Integer.parseInt(logParts[2]);

            if ("start".equals(logParts[1])) {
                // Function is starting now
                if (!stack.isEmpty()) {
                    // Add the exclusive time of previous function
                    result[stack.peek()] += curTime - prevTime;
                }
                stack.push(Integer.parseInt(logParts[0]));
                // Setting the start time for next log.
                prevTime = curTime;
            } else {
                // Function is ending now.
                // Make sure to +1 to as end takes the whole unit of time.
                result[stack.pop()] += curTime - prevTime + 1;
                // prevTime = resume time of the function. Thus adding 1.
                prevTime = curTime + 1;
            }
        }

        return result;
    }
}