//using Matrix  --- 0-based indexing 

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        boolean[]visited = new boolean[v];

        int provinces = 0;
        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(isConnected,visited,v,i);
                provinces++;
            }
        }
        return provinces;
    }
    static void dfs(int[][]isConnected,boolean[]visited,int v,int start){
        visited[start] = true;
        for(int j=0;j<v;j++){
            if(isConnected[start][j] == 1 && !visited[j]){
                dfs(isConnected,visited,v,j);
            }
        }
    }

}