class Solution {
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(check(board,word,i,j,0)) 
                    return true;
            }
        }
        return false;
    }

    static boolean check(char[][]board,String word,int r,int c,int index){

        //found answer
        if(index == word.length())
            return true;

        //boundary and char check
        if(r<0 || c<0 || r>=board.length || c>=board[0].length
            || board[r][c] != word.charAt(index))
            return false;

        //character matched , so mark it 
        char temp = board[r][c];
        board[r][c] = '!';

        // now look 4 directions from current to match next

        boolean found = check(board,word,r,c+1,index+1) || //right
                        check(board,word,r,c-1,index+1) || //left
                        check(board,word,r+1,c,index+1) || //down
                        check(board,word,r-1,c,index+1);  //up
        
        //restore the choice
        board[r][c] = temp;
        return found;

    }
}
