import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt(); // Number of nodes
        int vertex = sc.nextInt(); // Number of edges
        int[][] arr = new int[node + 1][node + 1];

        // Initializing the adjacency matrix
        for (int i = 0; i < vertex; i++) {
            int s = sc.nextInt(); // Start node
            int e = sc.nextInt(); // End node
            int w = sc.nextInt(); // Weight
            arr[s][e] = w;
            arr[e][s] = w; // Assuming undirected graph
        }

        // Print adjacency matrix (optional, for debugging)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int source = sc.nextInt(); // Source node
        int destination = sc.nextInt(); // Destination node

        int[] dist = new int[node + 1]; // Distance array
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances as infinity
        dist[source] = 0; // Distance to source is 0

        boolean[] visited = new boolean[node + 1]; // Visited array
        PriorityQueue<Integer> store = new PriorityQueue<>(Comparator.comparingInt(i -> dist[i]));
        store.add(source);

        while (!store.isEmpty()) {
            int curNode = store.poll();
            if (visited[curNode])
                continue; // Skip already visited nodes
            visited[curNode] = true;

            for (int neighbor = 1; neighbor <= node; neighbor++) {
                if (arr[curNode][neighbor] > 0 && !visited[neighbor]) { // Check for edge
                    int newDist = dist[curNode] + arr[curNode][neighbor];
                    if (newDist < dist[neighbor]) {
                        dist[neighbor] = newDist; // Update distance
                        store.add(neighbor);
                    }
                }
            }
        }

        // Print the shortest distance to the destination
        if (dist[destination] == Integer.MAX_VALUE) {
            System.out.println("No path exists from " + source + " to " + destination);
        } else {
            System.out.println("Shortest distance from " + source + " to " + destination + " is " + dist[destination]);
        }

        sc.close();
    }
}
