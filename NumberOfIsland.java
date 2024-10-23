import java.util.*;

class NumberOfIslands {
    public void dfs(Set<String> visited, char[][] grid, int row, int col) {
        Queue<int[]> store = new LinkedList<>();
        store.add(new int[] { row, col });
        visited.add(row + "," + col); // Mark the current cell as visited

        while (!store.isEmpty()) {
            int[] cur = store.poll();
            int i = cur[0];
            int j = cur[1];

            // Directions: Up, Down, Left, Right
            int[][] directions = {
                    { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }
            };

            for (int[] dir : directions) {
                int newRow = i + dir[0];
                int newCol = j + dir[1];

                // Check if the new cell is within bounds, not visited, and is land ('1')
                if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length
                        && !visited.contains(newRow + "," + newCol) && grid[newRow][newCol] == '1') {
                    store.add(new int[] { newRow, newCol }); // Add the new land cell to explore
                    visited.add(newRow + "," + newCol); // Mark it as visited
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        Set<String> visited = new HashSet<>(); // To track visited cells
        int count = 0; // Island counter

        // Traverse the entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If the cell is unvisited land, start a BFS/DFS to explore the entire island
                if (!visited.contains(i + "," + j) && grid[i][j] == '1') {
                    count++; // Increase the island count
                    dfs(visited, grid, i, j); // Explore the entire island
                }
            }
        }

        return count; // Return the number of islands
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();

        // Example grid
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        int numberOfIslands = solution.numIslands(grid);
        System.out.println("Number of islands: " + numberOfIslands);
    }
}
