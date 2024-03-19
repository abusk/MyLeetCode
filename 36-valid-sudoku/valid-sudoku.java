class Solution {
    
    private boolean check(List<Character> listC) {
        Set<Character> setC = new HashSet<>(listC);
        return listC.size() == setC.size();
    }
    private boolean checkAllRow(char[][] board) {
        for(int i = 0; i<9; i++){
            List<Character> listC = new ArrayList<>();
            for(int j = 0; j<9; j++){
                if(board[i][j] != '.'){
                    listC.add(board[i][j]);
                }
            }
            if(!check(listC)){
                return false;
            }
        }
        return true;
    }
    private boolean checkAllCol(char[][] board) {
        for(int i = 0; i<9; i++){
            List<Character> listC = new ArrayList<>();
            for(int j = 0; j<9; j++){
                if(board[j][i] != '.'){
                    listC.add(board[j][i]);
                }
            }
            if(!check(listC)){
                return false;
            }
        }
        return true;
    }
    
    private boolean checkAllSubBox(char[][] board) {
        for(int m = 0; m<=6; m+=3){
            for(int n = 0; n<=6; n+=3) {
                List<Character> listC = new ArrayList<>();
                for(int i = m; i<m+3; i++){
                    for(int j = n; j<n+3; j++){
                        if(board[i][j] != '.'){
                            listC.add(board[i][j]);
                        }
                    }
                    if(!check(listC)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        if(!checkAllRow(board)){
            return false;
        }
        if(!checkAllCol(board)){
            return false;
        }
        if(!checkAllSubBox(board)){
            return false;
        }
        return true;
    }
}