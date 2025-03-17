// class Solution {
//     static List<String> ans = new ArrayList<>();
//     record BallDir(int[] pos, String dirs){}
//     static char [] dik = {'d', 'l', 'u', 'r'};
//     static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
//     static Map<Character, int[]> dirMap = Map.of('d', new int[]{1, 0}, 'l',new int[]{0, -1}, 'u', new int[]{-1, 0}, 'r',new int[]{0, 1});
//     public static String findShortestWay(int[][] maze, int[] ball, int[] hole) {
//         ans.clear();
//         int row = maze.length;
//         int col = maze[0].length;

//         boolean[][] vis = new boolean[row][col];
//         bfs(maze, ball, hole, vis);
//         if(ans.isEmpty()) {
//             return "impossible";
//         }
//         ans.sort((a, b) -> (a+b).compareTo(b+a));
//         return ans.getFirst();
//     }
//     public static void bfs(int[][] maze, int[] ball, int[] hole, boolean[][] vis) {
//         int row = maze.length;
//         int col = maze[0].length;
//         Queue<BallDir> queue = new LinkedList<>();
//         queue.add(new BallDir(ball,""));

//         while (!queue.isEmpty()) {
//             BallDir item = queue.poll();
//             int[] ipos = item.pos;
//             vis[ipos[0]][ipos[1]] = true;
//             if (ipos[0] == hole[0] && ipos[1] == hole[1]) {
//                 ans.add(item.dirs);
//             } else {
//                 int nextPX = row;
//                 int nextPY = col;
//                 if(!item.dirs.isEmpty()) {
//                     char lastD = item.dirs.charAt(item.dirs.length() - 1);
//                     int[] nextD = dirMap.get(lastD);
//                     nextPX = ipos[0] + nextD[0];
//                     nextPY = ipos[1] + nextD[1];
//                 }
//                 if(((nextPX >= 0 && nextPX < row) && nextPY >=0 && nextPY < col) && maze[nextPX][nextPY] != 1) {
//                     BallDir nextItem = new BallDir(new int[]{nextPX, nextPY}, item.dirs);
//                     queue.offer(nextItem);
//                 } else {
//                     for (int i = 0; i< dir.length; i++) {
//                         int[] nst = dir[i];
//                         char d = dik[i];
//                         int nextX = ipos[0] + nst[0];
//                         int nextY = ipos[1] + nst[1];
//                         if(((nextX >= 0 && nextX < row) && nextY >=0 && nextY < col) && maze[nextX][nextY] != 1 && !vis[nextX][nextY]) {
//                             StringBuilder sbCopy = new StringBuilder(item.dirs);
//                             if(sbCopy.isEmpty() || sbCopy.charAt(sbCopy.length()-1) != d) {
//                                 sbCopy.append(d);
//                             }
//                             BallDir nextItem = new BallDir(new int[]{nextX, nextY}, sbCopy.toString());
//                             queue.offer(nextItem);
//                         }
//                     }
//                 }
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int[][] ma = {{0,0,0,0,0}, {1,1,0,0,1}, {0,0,0,0,0}, {0,1,0,0,1}, {0,1,0,0,0}};
//         int[] ball = {4,3};
//         int [] hole = {3, 0};
//         System.out.println(findShortestWay(ma, ball, hole));
//     }
// }

class State {
    int row;
    int col;
    int dist;
    String path;
    
    public State(int row, int col, int dist, String path) {
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.path = path;
    }
}

class Solution {
    int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    String[] textDirections = new String[]{"l", "u", "r", "d"};
    int m;
    int n;
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        m = maze.length;
        n = maze[0].length;
        
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> {
            int distA = a.dist;
            int distB = b.dist;
            
            if (distA == distB) {
                return a.path.compareTo(b.path);
            }
            
            return distA - distB;
        });
        
        boolean[][] seen = new boolean[m][n];
        heap.add(new State(ball[0], ball[1], 0, ""));
        
        while (!heap.isEmpty()) {
            State curr = heap.remove();
            int row = curr.row;
            int col = curr.col;
            
            if (seen[row][col]) {
                continue;
            }
            
            if (row == hole[0] && col == hole[1]) {
                return curr.path;
            }
            
            seen[row][col] = true;
            
            for (State nextState: getNeighbors(row, col, maze, hole)) {
                int nextRow = nextState.row;
                int nextCol = nextState.col;
                int nextDist = nextState.dist;
                String nextChar = nextState.path;
                heap.add(new State(nextRow, nextCol, curr.dist + nextDist, curr.path + nextChar));
            }
        }
        
        return "impossible";
    }
    
    private boolean valid(int row, int col, int[][] maze) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        return maze[row][col] == 0;
    }
    
    private List<State> getNeighbors(int row, int col, int[][] maze, int[] hole) {
        List<State> neighbors = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            int dy = directions[i][0];
            int dx = directions[i][1];
            String direction = textDirections[i];
            
            int currRow = row;
            int currCol = col;
            int dist = 0;
            
            while (valid(currRow + dy, currCol + dx, maze)) {
                currRow += dy;
                currCol += dx;
                dist++;
                if (currRow == hole[0] && currCol == hole[1]) {
                    break;
                }
            }
            
            neighbors.add(new State(currRow, currCol, dist, direction));
        }
        
        return neighbors;
    }
}