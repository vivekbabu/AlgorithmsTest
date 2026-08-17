package in.algorithms.dfs;

import java.util.*;

public class DFS {
    public static List<Integer> traverse(Map<Integer, List<Integer>> adjList, int startNode) {
        List<Integer> result = new ArrayList<>();
        if (adjList == null || !adjList.containsKey(startNode)) return result;
        Set<Integer> visited = new HashSet<>();
        dfsHelper(adjList, startNode, visited, result);
        return result;
    }

    private static void dfsHelper(Map<Integer, List<Integer>> adjList, int node, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        result.add(node);
        for (int neighbor : adjList.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(adjList, neighbor, visited, result);
            }
        }
    }
}
