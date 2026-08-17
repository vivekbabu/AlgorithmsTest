package in.algorithms.bfs;

import java.util.*;

public class BFS {
    public static List<Integer> traverse(Map<Integer, List<Integer>> adjList, int startNode) {
        List<Integer> result = new ArrayList<>();
        if (adjList == null || !adjList.containsKey(startNode)) return result;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return result;
    }
}
