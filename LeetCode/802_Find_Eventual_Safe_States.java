import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer>[] reverseGraph = new ArrayList[n];
        int[] inDegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        
        // Initialize reverse graph and in-degrees
        for (int i = 0; i < n; i++) {
            reverseGraph[i] = new ArrayList<>();
        }
        
        // Build reverse graph and compute in-degrees
        for (int node = 0; node < n; node++) {
            for (int adj : graph[node]) {
                reverseGraph[adj].add(node);
                inDegree[node]++;
            }
        }
        
        // Start with terminal nodes (nodes with zero in-degrees in the reverse graph)
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // Perform BFS to find all safe nodes
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            
            for (int prev : reverseGraph[node]) {
                if (--inDegree[prev] == 0) {
                    queue.add(prev);
                }
            }
        }
        
        // Sort the result list
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
