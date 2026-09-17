class Solution {
    List<List<String>> res = new ArrayList<>();
    public boolean isSafe(char[][]board, int row, int coln,int n){
        for(int i=0;i<n;i++){
            if(board[row][i] == 'Q') return false;
        }

        for(int i=0;i<n;i++){
            if(board[i][coln] == 'Q') return false;
        }
        //upper left diagonal
        for(int i = row,  j = coln; i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q') return false;

        }
        for(int i = row, j = coln; i>=0 && j<n;i--,j++){
            if(board[i][j] == 'Q') return false;
    }
        return true;
    }

    public void bfs(char[][] board, int n,int row, int coln){
        if(row == n) {
            ArrayList<String> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        for(coln = 0;coln<n;coln++){
            if(isSafe(board,row,coln,n)){
                board[row][coln] = 'Q';
                bfs(board,n,row+1,0);
                board[row][coln] = '.' ; //backtrack;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
       
        char[][] board = new char[n][n]; 
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        bfs(board,n,0,0);
        return res;

    }
}