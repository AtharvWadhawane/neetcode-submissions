class DSU{
    int[]parent;
    int[]rank;

    DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
    }

    int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(rank[pu] < rank[pv]) parent[pu] = pv;

        else if(rank[pv] < rank[pu]) parent[pv] = pu;

        else {
            parent[pv] = pu;
            rank[pu]++;
        }
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        
        //for a tree with n nodes there exists n-1 edges 

        if(edges.length != n-1) return false;  // this also clears check for (reachable nodes)

        DSU dsu = new DSU(n);

        for(int[] edge : edges){

            if(!dsu.union(edge[0],edge[1])) return false;
        }
        
        return true;
    }
}

