// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//         int l = Arrays.stream(positions).max().getAsInt();
//         List<int[]> lst = new ArrayList<>(l+1);
//         for(int i = 0; i<= l; i++) {
//             lst.add(new int[]{0,0,0});
//         }
//         for(int i = 0; i<positions.length; i++) {
//             int dir = directions.charAt(i) == 'L' ? 0 : 1;
//             int [] item = new int[] {i+1, healths[i], dir};
//             lst.set(positions[i], item);
//         }
//         List<int[]> fList = new ArrayList<>();
//         for(int[] itm : lst) {
//             if(itm[0] != 0) {
//                 fList.add(itm);
//             }
//         }
//         int prvSize = 0;
//         int curSize = 0;
//         do {
//             prvSize = fList.size();
//             int i = 1;
//             while(i<fList.size()) {
//                 int[] itm1 = fList.get(i-1);
//                 int[] itm2 = fList.get(i);
//                 if(itm1[2] != itm2[2]) {
//                     if(itm1[1] == itm2[1]) {
//                         fList.remove(i-1);
//                         fList.remove(i-1);
//                     } else if(itm1[1] > itm2[1]) {
//                         itm1[1]--;
//                         if(itm1[1] <= 0) {
//                             fList.remove(i-1);
//                             fList.remove(i-1);
//                         } else {
//                             fList.set(i-1, itm1);
//                             fList.remove(i);
//                         }
//                     } else {
//                         itm2[1]--;
//                         if(itm2[1] <= 0) {
//                             fList.remove(i-1);
//                             fList.remove(i-1);
//                         } else {
//                             fList.set(i, itm2);
//                             fList.remove(i-1);
//                         }
//                     }
//                 }
//                 i++;
//             }
//             curSize = fList.size();
//         } while(prvSize != curSize);

//         List<Integer> ans = new ArrayList<>();
//         fList.sort((a, b) -> a[0] - b[0]);
//         for(int[] it : fList) {
//             ans.add(it[1]);
//         }
//         return ans;
//     }
// }

class Solution {

    public List<Integer> survivedRobotsHealths(
        int[] positions,
        int[] healths,
        String directions
    ) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }

        Arrays.sort(
            indices,
            (lhs, rhs) -> Integer.compare(positions[lhs], positions[rhs])
        );

        for (int currentIndex : indices) {
            // Add right-moving robots to the stack
            if (directions.charAt(currentIndex) == 'R') {
                stack.push(currentIndex);
            } else {
                while (!stack.isEmpty() && healths[currentIndex] > 0) {
                    // Pop the top robot from the stack for collision check
                    int topIndex = stack.pop();

                    // Top robot survives, current robot is destroyed
                    if (healths[topIndex] > healths[currentIndex]) {
                        healths[topIndex] -= 1;
                        healths[currentIndex] = 0;
                        stack.push(topIndex);
                    } else if (healths[topIndex] < healths[currentIndex]) {
                        // Current robot survives, top robot is destroyed
                        healths[currentIndex] -= 1;
                        healths[topIndex] = 0;
                    } else {
                        // Both robots are destroyed
                        healths[currentIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }

        // Collect surviving robots
        for (int index = 0; index < n; ++index) {
            if (healths[index] > 0) {
                result.add(healths[index]);
            }
        }
        return result;
    }
}