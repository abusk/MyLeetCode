// class Solution {
//     public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
//         int[] maxs = maxStack(heights);
//         int[] ans = new int[queries.length];
//         int i=0;
//         for(int[] q : queries) {
//             Arrays.sort(q);
//             if(q[0] == q[1] || heights[q[0]] < heights[q[1]]) {
//                 ans[i++] = q[1];
//             } else {
//                 int meetInd = Math.max(maxs[q[0]], maxs[q[1]]);
//                 if(heights[q[0]] < heights[meetInd]) {
//                     ans[i++] = meetInd;
//                 } else {
//                     ans[i++] = -1;
//                 }
//             }
//         }
//         return ans;
//     }
//     public int[] maxStack(int[] heights) {
//         int [] ans = new int[heights.length];
//         Stack<Integer> st = new Stack<>();
//         for(int i = 0; i<heights.length; i++) {
//             while(!st.isEmpty() && heights[st.peek()] < heights[i]) {
//                 ans[st.pop()] = i;
//             }
//             st.push(i);
//         }
//         while(!st.isEmpty()) {
//             int ind = st.pop();
//             ans[ind] = ind;
//         }
//         return ans;
//     }
// }

class Solution {

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<Pair<Integer, Integer>> monoStack = new ArrayList<>();
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        List<List<Pair<Integer, Integer>>> newQueries = new ArrayList<>(
            heights.length
        );

        for (int i = 0; i < heights.length; i++) {
            newQueries.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (heights[b] > heights[a] || a == b) {
                result[i] = b;
            } else {
                newQueries.get(b).add(new Pair<>(heights[a], i));
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            int monoStackSize = monoStack.size();
            for (Pair<Integer, Integer> pair : newQueries.get(i)) {
                int position = search(pair.getKey(), monoStack);
                if (position < monoStackSize && position >= 0) {
                    result[pair.getValue()] = monoStack
                        .get(position)
                        .getValue();
                }
            }

            while (
                !monoStack.isEmpty() &&
                monoStack.get(monoStack.size() - 1).getKey() <= heights[i]
            ) {
                monoStack.remove(monoStack.size() - 1);
            }

            monoStack.add(new Pair<>(heights[i], i));
        }

        return result;
    }

    private int search(int height, List<Pair<Integer, Integer>> monoStack) {
        int left = 0;
        int right = monoStack.size() - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monoStack.get(mid).getKey() > height) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}