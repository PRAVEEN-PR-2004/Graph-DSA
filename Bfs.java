import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Bfs {
    private ArrayList<ArrayList<Integer>> adjList; // Changed to adjList for consistency

    // Constructor to initialize the adjacency list
    public Bfs() {
        this.adjList = new ArrayList<>();
    }

    // Method to add a vertex
    public void addVertex(int vertex) {
        adjList.add(new ArrayList<>());
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Undirected graph, add edge both ways
    }

    // BFS traversal from the start vertex
    public void BfsSearch(int startVertex) {
        Set<Integer> visited = new HashSet<>(); // To track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS

        queue.add(startVertex); // Start BFS from the given vertex
        visited.add(startVertex); // Mark it as visited

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.println("Visited vertex: " + currentVertex); // Process the current node

            // Traverse all unvisited neighbors of the current node
            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor); // Add to the queue for BFS
                    visited.add(neighbor); // Mark it as visited
                }
            }
        }
    }

    public static void main(String[] args) {
        Bfs g = new Bfs(); // Create the graph

        // Add 5 vertices (0 to 4)
        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        // Add edges between vertices
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(4, 3);

        // Perform BFS starting from vertex 0
        g.BfsSearch(0);
    }
}

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
// import java.util.Queue;
// import java.util.Set;

// public class Bfs {
// private Map<Integer, List<Integer>> adjList;

// public Bfs() {
// this.adjList = new HashMap<>();
// }

// public void addVertex(int vertex) {
// adjList.put(vertex, new ArrayList<>());
// }

// public void removeVertex(int vertex) {
// adjList.remove(vertex);
// for (List<Integer> al : adjList.values()) {
// al.remove(vertex);
// }
// }

// public void addEdge(int source, int destination) {
// adjList.get(source).add(destination);
// adjList.get(destination).add(source);
// }

// public void removeEdge(int source, int destination) {
// adjList.get(source).remove((Integer) destination);
// adjList.get(destination).remove((Integer) source);
// }

// public void BfsSearch(int startVertex) {
// Set<Integer> visited = new HashSet<>();
// Queue<Integer> store = new LinkedList<>();
// store.add(startVertex);
// visited.add(startVertex); // Mark the start vertex as visited when added to
// the queue

// while (!store.isEmpty()) {
// int currentVertex = store.poll();
// System.out.println(currentVertex); // Print the vertex as you process it

// // Traverse all unvisited neighbors
// for (int neighbor : adjList.get(currentVertex)) {
// if (!visited.contains(neighbor)) {
// store.add(neighbor);
// visited.add(neighbor); // Mark neighbor as visited when added to the queue
// }
// }
// }
// }

// public static void main(String[] args) {
// Bfs g = new Bfs();
// g.addVertex(0);
// g.addVertex(1);
// g.addVertex(2);
// g.addVertex(3);
// g.addVertex(4);
// g.addEdge(0, 1);
// g.addEdge(0, 4);
// g.addEdge(4, 3);
// g.addEdge(1, 2);
// g.BfsSearch(0);

// }
// }
