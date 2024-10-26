import java.util.*;

public class FloodFill {

    public void dfs(Set<String> visited, int[][] image, int i, int j, int originalColor) {
        Queue<int[]> store = new LinkedList<>();
        store.add(new int[] { i, j });
        visited.add(i + "," + j); // Mark the starting pixel as visited

        while (!store.isEmpty()) {
            int[] cur = store.poll();
            int row = cur[0];
            int col = cur[1];
            int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

            for (int[] dir : direction) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newCol >= 0 && newRow < image.length && newCol < image[0].length
                        && !visited.contains(newRow + "," + newCol) && image[newRow][newCol] == originalColor) {

                    visited.add(newRow + "," + newCol); // Mark as visited
                    store.add(new int[] { newRow, newCol }); // Add to the queue
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        Set<String> visited = new HashSet<>();

        int originalColor = image[sr][sc];

        // Only start DFS if the original color is different from the new color
        if (originalColor != color) {
            dfs(visited, image, sr, sc, originalColor);
        }

        // Update the image based on the visited cells
        for (String pos : visited) {
            String[] parts = pos.split(","); // Split the string to get coordinates
            int p = Integer.parseInt(parts[0]); // Extract row
            int r = Integer.parseInt(parts[1]); // Extract column
            image[p][r] = color; // Set the pixel to the new color
        }

        return image; // Return the updated image
    }

    public static void main(String[] args) {
        FloodFill solution = new FloodFill();

        int[][] image = {
                { 0, 0, 0 },
                { 0, 1, 0 }
        };
        int sr = 1; // Starting row
        int sc = 1; // Starting column
        int newColor = 2; // New color to fill

        System.out.println("Original Image:");
        printImage(image);

        // Perform the flood fill operation
        int[][] updatedImage = solution.floodFill(image, sr, sc, newColor);

        System.out.println("Updated Image:");
        printImage(updatedImage);
    }

    // Helper method to print the 2D image
    public static void printImage(int[][] image) {
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }
}
