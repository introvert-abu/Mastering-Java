package DSA.DataStructures.Graph;

public class Main {
    public static void main(String[] args) {
        DisjointSet djs = new DisjointSet(7);
        djs.unionByRank(1, 2);
        djs.unionByRank(2, 3);
        djs.unionByRank(4, 5);
        djs.unionByRank(6, 7);
        djs.unionByRank(5, 6);
        if (djs.find(3) == djs.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
        djs.unionByRank(3, 7);
        if (djs.find(3) == djs.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
