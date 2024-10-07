import java.util.Scanner;

public class AdjacencyMatrix {

    private int[][] adjMatrix;
    private int numVertices;

    public AdjacencyMatrix(int num) {

        numVertices = num;
        adjMatrix = new int[numVertices][numVertices];
    }

    // for undirected
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void deleteEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void addVertices() {
        int[][] newAdjMatrix = new int[numVertices + 1][numVertices + 1];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                newAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdjMatrix;
        numVertices++;

    }

    public void removeVertices(int v) {
        int[][] newAdjMatrix = new int[numVertices - 1][numVertices - 1];
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices - 1; j++) {
                if (i != v && j != v) {

                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
        }
        adjMatrix = newAdjMatrix;
        numVertices--;
    }

    public void displayGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        AdjacencyMatrix graph = new AdjacencyMatrix(vertices);
        int edges = sc.nextInt();

        // Add edges
        for (int i = 0; i < edges; i++) {
            System.out.print("Enter edge (u v): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        graph.displayGraph();
        sc.close();
    }
}