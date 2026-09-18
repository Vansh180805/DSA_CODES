class TotalNQueensSolver {
    int count = 0;
    boolean[] board;
    boolean[] d1;
    boolean[] d2;

    public void dfs(int row, int n){
        if(row == n){
            count++;
            return;
        }

        for(int coln=0;coln<n;coln++){

            if(board[coln] || d1[row-coln+n-1] || d2[row+coln]) 
            continue;

            board[coln] = true;
            d1[row-coln+n-1] = true;
            d2[row+coln] = true;

            dfs(row+1,n);

            board[coln] = false;
            d1[row-coln+n-1] = false;
            d2[row+coln] = false;
        }
    }

    public int totalNQueens(int n) {

        count = 0;
        board = new boolean[n];
        d1 = new boolean[2*n-1];
        d2 = new boolean[2*n-1];

        dfs(0,n);
        return count;
    }
}