import java.util.*;

public class dijkstra {

    static final int INF = Integer.MAX_VALUE;
    static String[] names = {"Mumbai", "Delhi", "Chennai", "Kolkata", "Pune", "Jaipur", "Bengaluru"};
    static int V = names.length;

    public static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V];
        boolean[] done = new boolean[V];
        String[] path = new String[V];

        Arrays.fill(dist, INF);
        Arrays.fill(path, "");
        dist[src] = 0;
        path[src] = names[src];

        for (int step = 0; step < V - 1; step++) {
            int u = pickMin(dist, done);
            done[u] = true;

            System.out.println("Step " + (step + 1) + ":");
            System.out.println("Visited: " + Arrays.toString(done));
            System.out.println("Distances: " + Arrays.toString(dist));

            for (int v = 0; v < V; v++) {
                if (!done[v] && graph[u][v] > 0 && dist[u] != INF &&
                    dist[u] + graph[u][v] < dist[v]) {
                    
                    dist[v] = dist[u] + graph[u][v];
                    path[v] = path[u] + " -> " + names[v];
                }
            }
            System.out.println("Paths: " + Arrays.toString(path) + "\n");
        }

        System.out.println("\nSource\tDestination\tDistance\tPath");
        for (int i = 0; i < V; i++) {
            if (i != src) {
                System.out.println(names[src] + " -> " + names[i] + "\t" +
                                dist[i] + "\t\t" + path[i]);
            }
        }
    }

    private static int pickMin(int[] dist, boolean[] done) {
        int min = INF, idx = -1;
        for (int i = 0; i < V; i++) {
            if (!done[i] && dist[i] <= min) {
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 8, 15, 0, 0, 0, 0},   // Mumbai
            {8, 0, 7, 12, 0, 0, 0},   // Delhi
            {15, 7, 0, 9, 6, 14, 0},  // Chennai
            {0, 12, 9, 0, 11, 0, 10}, // Kolkata
            {0, 0, 6, 11, 0, 0, 13},  // Pune
            {0, 0, 14, 0, 0, 0, 5},   // Jaipur
            {0, 0, 0, 10, 13, 5, 0}   // Bengaluru
        };

        dijkstra(graph, 0); // Source: Mumbai
    }
}


