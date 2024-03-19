// class Solution {
    
//     private boolean check(List<Character> listC) {
//         Set<Character> setC = new HashSet<>(listC);
//         return listC.size() == setC.size();
//     }
//     private boolean checkAllRow(char[][] board) {
//         for(int i = 0; i<9; i++){
//             List<Character> listC = new ArrayList<>();
//             for(int j = 0; j<9; j++){
//                 if(board[i][j] != '.'){
//                     listC.add(board[i][j]);
//                 }
//             }
//             if(!check(listC)){
//                 return false;
//             }
//         }
//         return true;
//     }
//     private boolean checkAllCol(char[][] board) {
//         for(int i = 0; i<9; i++){
//             List<Character> listC = new ArrayList<>();
//             for(int j = 0; j<9; j++){
//                 if(board[j][i] != '.'){
//                     listC.add(board[j][i]);
//                 }
//             }
//             if(!check(listC)){
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     private boolean checkAllSubBox(char[][] board) {
//         for(int m = 0; m<=6; m+=3){
//             for(int n = 0; n<=6; n+=3) {
//                 List<Character> listC = new ArrayList<>();
//                 for(int i = m; i<m+3; i++){
//                     for(int j = n; j<n+3; j++){
//                         if(board[i][j] != '.'){
//                             listC.add(board[i][j]);
//                         }
//                     }
//                     if(!check(listC)){
//                         return false;
//                     }
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean isValidSudoku(char[][] board) {
//         if(!checkAllRow(board)){
//             return false;
//         }
//         if(!checkAllCol(board)){
//             return false;
//         }
//         if(!checkAllSubBox(board)){
//             return false;
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;

        // Use hash set to record the status
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];
        for (int r = 0; r < N; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char val = board[r][c];

                // Check if the position is filled with number
                if (val == '.') {
                    continue;
                }

                // Check the row
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // Check the column
                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                // Check the box
                int idx = (r / 3) * 3 + c / 3;
                if (boxes[idx].contains(val)) {
                    return false;
                }
                boxes[idx].add(val);
            }
        }
        return true;
    }
}