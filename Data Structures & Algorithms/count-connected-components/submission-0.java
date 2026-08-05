class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            dsu.union(u,v);
        }

        int count = 0;

        for(int i=0;i<n;i++){
            if(dsu.find(i) == i) 
                count++;
        }
        return  count;
    }
}
class DSU{
    int[]parent;
    int[]rank;

    DSU(int node){
        parent = new int[node];
        rank = new int[node];

        for(int i=0;i<node;i++){
            parent[i] = i;
        }
    }


    int find(int u){
        if(parent[u] != u){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;

        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }
        else if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }
        else{
            parent[pv] = pu;
            rank[pu]++;
        }
    }
}
