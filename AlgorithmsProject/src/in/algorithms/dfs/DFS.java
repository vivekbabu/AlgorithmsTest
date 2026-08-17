package in.algorithms.dfs;

import java.util.*;

public class DFS {
    public static void dfsTraversal(Map<Integer, List<Integer>> adj, int start) {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(adj, start, visited);
        System.out.println();
    }

    private static void dfsUtil(Map<Integer, List<Integer>> adj, int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(adj, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(0, Arrays.asList(1, 2));
        adj.put(1, Arrays.asList(2));
        adj.put(2, Arrays.asList(0, 3));
        adj.put(3, Arrays.asList(3));

        System.out.print("DFS from vertex 2: ");
        dfsTraversal(adj, 2);
    }
}
