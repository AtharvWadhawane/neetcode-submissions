class Solution {
    private static  final int[][]directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][]safe = new boolean[n][m];

        //check if any 0 is at boarder (that 0 is safe)

        //top & bottom
        for(int c=0;c<m;c++){
            dfs(0,c,board,safe); 
            dfs(n-1,c,board,safe);
        }
        //left & right 
        for(int r=0;r<n;r++){
            dfs(r,0,board,safe);
            dfs(r,m-1,board,safe);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] != 'X' && !safe[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
    void dfs(int r, int c,char[][]board,boolean[][]safe){

        if(r<0 || c<0 || r>=board.length || c>=board[0].length
            || board[r][c] == 'X' || safe[r][c]){
                return;
            }
        
        safe[r][c] = true;

        for(int[]d : directions){
            dfs(r+d[0],c+d[1],board,safe);
        }
    }
}
