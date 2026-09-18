class SudokuSolver {
    public boolean Valid(char[][] board, int row, int col, char num){

        for(int i=0;i<9;i++){
            if(board[row][i] == num)
                return false;
            if(board[i][col] == num)
                return false;
        }

        int srow = (row/3)*3;
        int scol = (col/3)*3;

        for(int i=srow;i<srow+3;i++){
            for(int j = scol;j<scol+3;j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(char[][] board){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col] == '.'){

                    for(char num = '1';num<='9';num++){
                        if(Valid(board,row,col,num)){

                            board[row][col] = num;

                            if(solve(board)){
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
        

        
    }
}