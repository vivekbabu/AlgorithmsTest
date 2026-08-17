package in.algorithms.bfs;

import java.util.*;

public class BFS {
    public static void bfsTraversal(Map<Integer, List<Integer>> adj, int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            List<Integer> neighbors = adj.getOrDefault(node, Collections.emptyList());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        adj.put(0, Arrays.asList(1, 2));
        adj.put(1, Arrays.asList(2));
        adj.put(2, Arrays.asList(0, 3));
        adj.put(3, Arrays.asList(3));

        System.out.print("BFS from vertex 2: ");
        bfsTraversal(adj, 2);
    }
}
