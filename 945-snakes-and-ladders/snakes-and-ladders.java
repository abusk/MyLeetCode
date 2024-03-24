// class Solution {
//     public int snakesAndLadders(int[][] board) {
//         int n = board.length;
//         int nn = n*n;
//         Queue<Integer> q = new LinkedList<>();
//         Set<Integer> visted = new HashSet<>();
//         q.add(1);
//         int c = -1;
//         boolean end = false;
//         while(!q.isEmpty()){
//             int l = q.size();
//             c++;
//             if(end) {
//                 break;
//             }
//             while(l > 0){
//                 int node = q.poll();
                
//                 int next = node+6;
//                 if(next >= nn){
//                     next = nn;
//                 }
//                 if(node == nn) {
//                     end = true;
//                     break;
//                 }
//                 if(!visted.contains(next)){
//                     visted.add(next);
//                     q.add(next);
//                 }
//                 int row = n-1-node/n;
//                 for(int col = 0; col<n; col++){
//                     if(board[row][col] != -1){
//                         next = board[row][col];
//                         if(!visted.contains(next) && next != node){
//                             visted.add(next);
//                             q.add(next);
//                         }
//                     }
//                 }
//                 l--;
//             }
            
//         }
//         return c;
//     }
// }

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        int label = 1;
        Integer[] columns = new Integer[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        for (int row = n - 1; row >= 0; row--) {
            for (int column : columns) {
                cells[label++] = new Pair<>(row, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[n * n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        dist[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                int row = cells[next].getKey(), column = cells[next].getValue();
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        return dist[n * n];
    }
}