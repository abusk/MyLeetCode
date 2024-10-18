// class Solution {
//     public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//         List<int[]> allP = new ArrayList<>();
//         boolean topLeft = false;
//         boolean topRight = false;
//         boolean bottomLeft = false;
//         boolean bottomRight = false;
//         int rl = 1;
//         int cl = 1;

//         allP.add(new int[]{rStart, cStart});
//         while (!topLeft || !topRight || !bottomLeft || !bottomRight) {
//             List<int[]> r = right(rStart, cStart, rl);
//             rl++;
//             allP.addAll(r);
//             int[] lr = r.getLast();
//             rStart = lr[0];
//             cStart = lr[1];

//             List<int[]> d = down(rStart, cStart, cl);
//             cl++;
//             allP.addAll(d);
//             int[] ld = d.getLast();
//             rStart = ld[0];
//             cStart = ld[1];

//             List<int[]> l = left(rStart, cStart, rl);
//             rl++;
//             allP.addAll(l);
//             int[] ll = l.getLast();
//             rStart = ll[0];
//             cStart = ll[1];

//             List<int[]> u = up(rStart, cStart, cl);
//             cl++;
//             allP.addAll(u);
//             int[] lu = u.getLast();
//             rStart = lu[0];
//             cStart = lu[1];

//             if(visited(allP, new int[]{0, 0})) {
//                 topLeft = true;
//             }
//             if(visited(allP, new int[]{0, cols})) {
//                 topRight = true;
//             }
//             if(visited(allP, new int[]{rows, 0})) {
//                 bottomLeft = true;
//             }
//             if(visited(allP, new int[]{rows, cols})) {
//                 bottomRight = true;
//             }
//         }
//         int[][] res = new int[rows*cols][2];
//         int i=0;
//         for(int[] p: allP) {
//             if((p[0] >=0 && p[0] < rows) &&(p[1] >=0 && p[1]<cols)) {
//                 res[i++]= p;
//             }
//         } 
//         return res;
//     }
//     private boolean visited(List<int[]> allP, int[] corner) {
//         for(int[]p : allP) {
//             if(p[0] == corner[0] && p[1] == corner[1]) {
//                 return true;
//             }
//         }
//         return false;
//     }
//     private List<int[]> right(int row, int col, int rl) {
//         List<int[]> list = new ArrayList<>();
//         for(int i =1; i<=rl; i++) {
//             list.add(new int[]{row, col+i});
//         }
//         return list;
//     }
//     private List<int[]> down(int row, int col, int cl) {
//         List<int[]> list = new ArrayList<>();
//         for(int i =1; i<=cl; i++) {
//             list.add(new int[]{row+i, col});
//         }
//         return list;
//     }
//     private List<int[]> left(int row, int col, int rl) {
//         List<int[]> list = new ArrayList<>();
//         for(int i =1; i<=rl; i++) {
//             list.add(new int[]{row, col-i});
//         }
//         return list;
//     }
//     private List<int[]> up(int row, int col, int cl) {
//         List<int[]> list = new ArrayList<>();
//         for(int i =1; i<=cl; i++) {
//             list.add(new int[]{row-i, col});
//         }
//         return list;
//     }
// }

class Solution {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Store all possible directions in an array.
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] traversed = new int[rows * cols][2];
        int idx = 0;

        // Initial step size is 1, value of d represents the current direction.
        for (int step = 1, direction = 0; idx < rows * cols;) {
            // direction = 0 -> East, direction = 1 -> South
            // direction = 2 -> West, direction = 3 -> North
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < step; ++j) {
                    // Validate the current position
                    if (
                        rStart >= 0 &&
                        rStart < rows &&
                        cStart >= 0 &&
                        cStart < cols
                    ) {
                        traversed[idx][0] = rStart;
                        traversed[idx][1] = cStart;
                        ++idx;
                    }
                    // Make changes to the current position.
                    rStart += dir[direction][0];
                    cStart += dir[direction][1];
                }

                direction = (direction + 1) % 4;
            }
            ++step;
        }
        return traversed;
    }
}