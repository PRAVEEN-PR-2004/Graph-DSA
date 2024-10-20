import java.util.*;;

public class Dfs {
    private Map<Integer, List<Integer>> adjList;

    public Dfs() {
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
        adjList.get(source).remove(destination);
        adjList.get(destination).remove(source);
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

    public void DFSIterative(int startVertex) {
        Set<Integer> visited = new HashSet<>(); // To keep track of visited vertices
        Stack<Integer> st = new Stack<>(); // Stack for DFS traversal
        st.push(startVertex); // Start with the starting vertex

        while (!st.isEmpty()) {
            int currentVertex = st.pop(); // Pop the top of the stack

            // If this vertex has not been visited yet
            if (!visited.contains(currentVertex)) {
                System.out.print(currentVertex + " "); // Process the vertex (e.g., print it)
                visited.add(currentVertex); // Mark it as visited

                // Push all unvisited neighbors onto the stack
                for (int neighbor : adjList.get(currentVertex)) {
                    if (!visited.contains(neighbor)) {
                        st.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Dfs g = new Dfs();
        g.addVertex(0);
        g.addVertex(2);
        g.addVertex(1);
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.printAdjList();
        g.DFSIterative(0);

    }

}