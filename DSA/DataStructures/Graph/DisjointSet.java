package DSA.DataStructures.Graph;

import java.util.Arrays;

public class DisjointSet {
    int[] parent, size, rank;

    DisjointSet (int n) {
        parent = new int[n+1];
        size = new int[n+1];
        rank = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        Arrays.fill(size, 1);
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void unionByRank(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);

        if (parentU == parentV) {
            return;
        }

        if (rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else if (rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }

    public void unionBySize(int u, int v) {
        int parentU = find(u);
        int parentV = find(v);

        if (size[parentU] > size[parentV]) {
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        } else {            
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        }
    }
}
