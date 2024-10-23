import java.util.*;

public class NumberOfProvinces {
    public void dfs(int start, List<ArrayList<Integer>> adjLis, Set<Integer> hs) {
        Stack<Integer> st = new Stack<>();
        st.push(start);
        while (!st.isEmpty()) {
            int current = st.pop();
            if (!hs.contains(current)) {
                hs.add(current);
                for (int neighbor : adjLis.get(current)) {
                    if (!hs.contains(neighbor)) {
                        st.push(neighbor);
                    }
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<ArrayList<Integer>> adjLis = new ArrayList<>();
        int len = isConnected.length;
        for (int i = 0; i < len; i++) {
            adjLis.add(new ArrayList<>());
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLis.get(i).add(j);
                    adjLis.get(j).add(i);
                }
            }
        }
        Set<Integer> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (!hs.contains(i)) {
                count++;
                dfs(i, adjLis, hs);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example input: Adjacency matrix representing connected cities
        int[][] isConnected = {
                { 1, 1, 0 },
                { 1, 1, 0 },
                { 0, 0, 1 }
        };

        NumberOfProvinces solution = new NumberOfProvinces();
        int numOfProvinces = solution.findCircleNum(isConnected);

        // Output the result
        System.out.println("Number of provinces: " + numOfProvinces);
    }
}
