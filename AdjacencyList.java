import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AdjacencyList {
    private Map<Integer, List<Integer>> adjList;

    public AdjacencyList() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjList.put(vertex, new LinkedList<>());
    }

    public void removeVertex(int vertex) {
        adjList.remove(vertex);
        for (List<Integer> al : adjList.values()) {
            al.remove((Integer) vertex);
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    public void removeEdge(int source, int destination) {
        adjList.get(source).remove((Integer) destination);
        adjList.get(destination).remove((Integer) source);
    }

    public void printAdjList() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + " is connected to: ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println(); // Move to the next line after printing all neighbors
        }
    }

    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList();

        g.addVertex(1); // Adding a vertex example
        g.addVertex(2); // Another vertex
        g.addVertex(3); // Adding a vertex example
        g.addVertex(4); // Another vertex

        g.addEdge(2, 1);
        g.addEdge(4, 1);
        g.addEdge(1, 3);
        g.printAdjList();
    }
}
