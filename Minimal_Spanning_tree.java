import java.util.*;

class Edge {
    int src, dest, wt;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        wt = w;
    }
}

public class Minimal_Spanning_Tree {

    static int parent[] = new int[5];
    static int rank[] = new int[5];

    static void makeSet(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    static int find(int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    static void union(int s, int d) {

        int rootS = find(s);
        int rootD = find(d);

        if (rank[rootS] > rank[rootD]) {
            parent[rootD] = rootS;
        }
        else if (rank[rootD] > rank[rootS]) {
            parent[rootS] = rootD;
        }
        else {
            parent[rootD] = rootS;
            rank[rootS]++;
        }
    }

    static int mst(ArrayList<Edge> graph) {

        Collections.sort(graph, (a, b) -> a.wt - b.wt);

        int cost = 0;

        for (Edge e : graph) {

            int s = e.src;
            int d = e.dest;

            if (find(s) != find(d)) {
                union(s, d);
                cost += e.wt;
            }
        }

        return cost;
    }

    public static void main(String[] args) {

        ArrayList<Edge> graph = new ArrayList<>();

        graph.add(new Edge(0,1,3));
        graph.add(new Edge(0,2,2));
        graph.add(new Edge(1,3,2));
        graph.add(new Edge(2,3,7));
        graph.add(new Edge(1,4,4));
        graph.add(new Edge(2,4,3));
        graph.add(new Edge(3,4,1));

        makeSet(5);

        System.out.println("MST Cost = " + mst(graph));
    }
}