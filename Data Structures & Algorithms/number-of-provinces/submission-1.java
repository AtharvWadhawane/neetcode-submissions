class Solution {

    static void dfs(List<List<Integer>>adj,int[]visited,int v,int start){
        visited[start] = 1;
        for(int nb : adj.get(start)){
            if(visited[nb] == 0){
                dfs(adj,visited,v,nb);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;   
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[]visited = new int[v];
        int provinces = 0;
        for(int i=0;i<v;i++){
            if(visited[i] == 0){
                dfs(adj,visited,v,i);
                provinces++;
            }
        }
        return provinces;
    }
}