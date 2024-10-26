import java.util.*;

class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> store = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        // Add all rotten oranges to the queue with time 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    store.add(new int[] { i, j, 0 });
                    visited.add(i + "," + j);
                }
            }
        }

        int time = 0;

        // BFS to rot adjacent fresh oranges
        while (!store.isEmpty()) {
            int[] cur = store.poll();
            int row = cur[0];
            int col = cur[1];
            int t = cur[2];

            time = Math.max(t, time); // Update the maximum time to rot oranges

            // Explore all 4 directions
            int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // If the new position is within bounds and contains a fresh orange
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < m &&
                        !visited.contains(newRow + "," + newCol) && grid[newRow][newCol] != 0) {

                    visited.add(newRow + "," + newCol);
                    store.add(new int[] { newRow, newCol, t + 1 });
                    grid[newRow][newCol] = 2; // Mark as rotten
                }
            }
        }

        // Check if there are any fresh oranges left
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1; // Return -1 if fresh oranges are still present
            }
        }

        return time;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();

        // Sample test case
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        int result = solution.orangesRotting(grid);
        System.out.println("Minutes to rot all oranges: " + result);
    }
}
