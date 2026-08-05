class Solution {
    static void dfs(int[][]image,int i,int j,int ogcolor,int newcolor){
        
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || 
        image[i][j] != ogcolor){
            return;
        }
        image[i][j] = newcolor;
        dfs(image,i-1,j,ogcolor,newcolor);
        dfs(image,i,j+1,ogcolor,newcolor);
        dfs(image,i,j-1,ogcolor,newcolor);
        dfs(image,i+1,j,ogcolor,newcolor);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogcolor = image[sr][sc];
        if(ogcolor == color) return image;
        dfs(image,sr,sc,ogcolor,color);
        return image;
    }
}