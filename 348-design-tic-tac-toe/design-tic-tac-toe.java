// class TicTacToe {
//     int n;
//     Map<Integer, Map<String, Map<Integer, Set<Integer>>>> map;
//     public TicTacToe(int n) {
//         this.n = n;
//         map = new HashMap<>();
//         map.put(1, generatePrcdm());
//         map.put(2, generatePrcdm());
//     }
//     public Map<String, Map<Integer, Set<Integer>>> generatePrcdm() {
//         Map<String, Map<Integer, Set<Integer>>> prcdm = new HashMap<>();
//         prcdm.put("row", generateRm());
//         prcdm.put("col", generateRm());
//         prcdm.put("dio", generateRm());
//         prcdm.put("rdio", generateRm());
//         return prcdm;
//     }
//     public Map<Integer, Set<Integer>> generateRm() {
//         Map<Integer, Set<Integer>> rm = new HashMap<>();
//         for(int i = 0; i<n; i++) {
//             rm.put(i, new HashSet<>());
//         }
//         return rm;
//     }

//     public int move(int row, int col, int player) {
//       map.get(player).get("row").get(row).add(col);
//       map.get(player).get("col").get(col).add(row);
//       if(row == col) {
//         map.get(player).get("dio").get(row).add(col);
//       }
//       if(col == n-1-row) {
//         map.get(player).get("rdio").get(row).add(col);
//       }
//       if(isWin(map.get(player))) {
//         return player;
//       } else {
//         return 0;
//       }
//     }
//     public boolean isWin(Map<String, Map<Integer, Set<Integer>>> rcdm) {
//         Map<Integer, Set<Integer>> rows = rcdm.get("row");
//         for(Set<Integer> row: rows.values()) {
//             if(row.size() == n) {
//                 return true;
//             }
//         }
//         Map<Integer, Set<Integer>> cols = rcdm.get("col");
//         for(Set<Integer> col: cols.values()) {
//             if(col.size() == n) {
//                 return true;
//             }
//         }
//         Map<Integer, Set<Integer>> dios = rcdm.get("dio");
//         boolean dflag = true;
//         for(Set<Integer> dio: dios.values()) {
//             if(dio.isEmpty()) {
//                 dflag = false;
//             }
//         }
//         if(dflag) {
//             return true;
//         }
//         Map<Integer, Set<Integer>> rdios = rcdm.get("rdio");
//         boolean rflag = true;
//         for(Set<Integer> rdio: rdios.values()) {
//             if(rdio.isEmpty()) {
//                 rflag = false;
//             }
//         }
//         if(rflag) {
//             return true;
//         }
//         return false;
//     }
// }

// /**
//  * Your TicTacToe object will be instantiated and called as such:
//  * TicTacToe obj = new TicTacToe(n);
//  * int param_1 = obj.move(row,col,player);
//  */

public class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;

    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int currentPlayer = (player == 1) ? 1 : -1;
        // update currentPlayer in rows and cols arrays
        rows[row] += currentPlayer;
        cols[col] += currentPlayer;
        // update diagonal
        if (row == col) {
            diagonal += currentPlayer;
        }
        //update anti diagonal
        if (col == (cols.length - row - 1)) {
            antiDiagonal += currentPlayer;
        }
        int n = rows.length;
        // check if the current player wins
        if (Math.abs(rows[row]) == n ||
                Math.abs(cols[col]) == n ||
                Math.abs(diagonal) == n ||
                Math.abs(antiDiagonal) == n) {
            return player;
        }
        // No one wins
        return 0;
    }
}
