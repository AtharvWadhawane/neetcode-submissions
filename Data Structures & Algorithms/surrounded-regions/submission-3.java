class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if (n < 3 || m < 3) return; // early exit

        boolean[][] safe = new boolean[n][m];

        // top & bottom borders
        for (int c = 0; c < m; c++) {
            if (board[0][c] == 'O' && !safe[0][c]) dfs(0, c, board, safe);
            if (board[n-1][c] == 'O' && !safe[n-1][c]) dfs(n-1, c, board, safe);
        }
        // left & right borders
        for (int r = 0; r < n; r++) {
            if (board[r][0] == 'O' && !safe[r][0]) dfs(r, 0, board, safe);
            if (board[r][m-1] == 'O' && !safe[r][m-1]) dfs(r, m-1, board, safe);
        }

        // flip surrounded regions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !safe[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean[][] safe) {
        int n = board.length, m = board[0].length;
        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] == 'X' || safe[r][c]) return;

        safe[r][c] = true;
        for (int[] d : directions) {
            dfs(r + d[0], c + d[1], board, safe);
        }
    }
}
