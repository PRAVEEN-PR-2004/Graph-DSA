import java.util.ArrayList;

public class AdjacencyList {

    private ArrayList<ArrayList<Integer>> adList;

    // Constructor to initialize the adjacency list
    AdjacencyList(int vertex) {
        adList = new ArrayList<>(vertex); // Initialize the adList
        for (int i = 0; i < vertex; i++) { // Start from 0 (0-indexed)
            adList.add(new ArrayList<>());
        }
    }

    // Method to add an edge between source and destination
    public void addEdge(int source, int destination) {
        adList.get(source).add(destination);
        adList.get(destination).add(source);
    }

    // Method to print the adjacency list
    public void printAdjList() {
        for (int i = 0; i < adList.size(); i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer neighbor : adList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5); // Create a graph with 5 vertices

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the adjacency list
        graph.printAdjList();
    }
}

// public class AdjacencyList {
// private Map<Integer, List<Integer>> adjList;

// public AdjacencyList() {
// this.adjList = new HashMap<>();
// }

// public void addVertex(int vertex) {
// adjList.put(vertex, new LinkedList<>());
// }

// public void removeVertex(int vertex) {
// adjList.remove(vertex);
// for (List<Integer> al : adjList.values()) {
// al.remove((Integer) vertex);
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

// public void printAdjList() {
// for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
// System.out.print("Vertex " + entry.getKey() + " is connected to: ");
// for (Integer neighbor : entry.getValue()) {
// System.out.print(neighbor + " ");
// }
// System.out.println(); // Move to the next line after printing all neighbors
// }
// }

// public static void main(String[] args) {
// AdjacencyList g = new AdjacencyList();

// g.addVertex(1); // Adding a vertex example
// g.addVertex(2); // Another vertex
// g.addVertex(3); // Adding a vertex example
// g.addVertex(4); // Another vertex

// g.addEdge(2, 1);
// g.addEdge(4, 1);
// g.addEdge(1, 3);
// g.printAdjList();
// }
// }
