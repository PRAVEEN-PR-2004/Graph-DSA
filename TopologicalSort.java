import java.io.*;
import java.util.*;

class TopologicalSort {
    public static void main(String[] args) throws IOException {
        // Default input
        String input = "1\n6\n6\n5 0\n5 2\n4 0\n4 1\n2 3\n3 1";
        BufferedReader read = new BufferedReader(new StringReader(input));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int vertices = Integer.parseInt(read.readLine());
            int edges = Integer.parseInt(read.readLine());

            for (int i = 0; i < vertices; i++)
                adj.add(new ArrayList<>());

            for (int i = 0; i < edges; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
            }

            ArrayList<Integer> res = new Solution().topologicalSort(adj);

            if (check(adj, vertices, res))
                System.out.println("1");
            else
                System.out.println("0");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V, ArrayList<Integer> res) {
        if (V != res.size())
            return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v])
                    return false;
            }
        }
        return true;
    }
}

class Solution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[adj.size()];
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                dfs(adj, vis, st, i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st, int cur) {
        vis[cur] = 1;
        for (int i : adj.get(cur)) {
            if (vis[i] == 0) {
                dfs(adj, vis, st, i);
            }
        }
        st.push(cur);
    }
}
