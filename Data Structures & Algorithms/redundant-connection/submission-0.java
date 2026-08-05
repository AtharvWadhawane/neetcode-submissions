class DSU{
    int[]parents;
    int[]ranks;

    DSU(int n){
        parents = new int[n+1]; //1-based indexing
        ranks = new int[n+1];
        for(int i=0;i<=n;i++){
            parents[i] = i;
        }
    }

    int find(int x){ // x -> node
        if(parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    boolean union(int u,int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return false;

        if(ranks[pu]<ranks[pv]) parents[pu] = pv;

        else if(ranks[pv]<ranks[pu]) parents[pv] = pu;

        else parents[pv] = pu; // when both have same rank choose arbitrarily
            ranks[pu]++;
    
    return true;
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU d = new DSU(n);

        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!d.union(u,v)) return edge;
        }
        return new int[0];
    }
}
