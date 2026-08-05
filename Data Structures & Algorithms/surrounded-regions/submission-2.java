class Solution {
    private static  final int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        //check if any 0 is at boarder (that 0 is safe)

        //top & bottom
        for(int c=0;c<m;c++){
            if(board[0][c] == 'O') dfs(0,c,board); 
            if(board[n-1][c] == 'O') dfs(n-1,c,board);
        }
        //left & right 
        for(int r=0;r<n;r++){
            if(board[r][0] == 'O') dfs(r,0,board);
            if(board[r][m-1] == 'O') dfs(r,m-1,board);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] != 'X' && board[i][j] != '#'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
    void dfs(int r, int c,char[][]board){

        if(r<0 || c<0 || r>=board.length || c>=board[0].length
            || board[r][c] == 'X' || board[r][c] == '#'){
                return;
            }
        
        board[r][c] = '#';

        for(int[]d : directions){
            dfs(r+d[0],c+d[1],board);
        }
    }
}
