import java.util.*;

public class Dfs {
    private ArrayList<ArrayList<Integer>> adjList; // Use ArrayList of ArrayLists

    // Constructor to initialize the adjacency list
    public Dfs(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize each vertex's list
        }
    }

    // Method to add an edge between two vertices
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // Undirected graph, add both directions
    }

    // Method to print the adjacency list
    public void printAdjList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Iterative DFS method
    public void DFSIterative(int startVertex) {
        Set<Integer> visited = new HashSet<>(); // To keep track of visited vertices
        Stack<Integer> stack = new Stack<>(); // Stack for DFS traversal

        stack.push(startVertex); // Start with the given vertex

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop(); // Pop the top of the stack

            // If this vertex has not been visited yet
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " "); // Process the vertex (e.g., print it)
                visited.add(currentVertex); // Mark it as visited

                // Push all unvisited neighbors onto the stack
                for (int neighbor : adjList.get(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int numVertices = 3; // Define the number of vertices
        Dfs g = new Dfs(numVertices); // Create the graph with 3 vertices

        // Add edges between vertices
        g.addEdge(0, 1);
        g.addEdge(2, 1);

        // Print adjacency list and perform DFS
        g.printAdjList();
        System.out.println("DFS starting from vertex 0:");
        g.DFSIterative(0);
    }
}
