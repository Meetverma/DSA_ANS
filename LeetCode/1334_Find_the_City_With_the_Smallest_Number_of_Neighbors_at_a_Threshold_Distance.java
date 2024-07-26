import java.util.*;

class Solution {

    public void dijkstra(List<int[]>[] adjList, int n, int[] shortestPath, int startNode) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{startNode, 0});
        Arrays.fill(shortestPath, Integer.MAX_VALUE);
        shortestPath[startNode] = 0;

        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            int currentCity = currentNode[0];
            int currentDist = currentNode[1];

            if (currentDist > shortestPath[currentCity]) continue;

            for (int[] neighbor : adjList[currentCity]) {
                int next = neighbor[0];
                int nextWt = neighbor[1];
                if (shortestPath[next] > currentDist + nextWt) {
                    shortestPath[next] = currentDist + nextWt;
                    queue.add(new int[]{next, shortestPath[next]});
                }
            }
        }
    }

    public int cityHelper(int n, int[][] shortestPath, int distThreshold) {
        int leastCity = -1;
        int fewestTillNow = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int reachable = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (shortestPath[i][j] <= distThreshold) {
                    reachable++;
                }
            }
            if (reachable < fewestTillNow || (reachable == fewestTillNow && i > leastCity)) {
                fewestTillNow = reachable;
                leastCity = i;
            }
        }
        return leastCity;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] adjList = new List[n];
        int[][] shortestPath = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPath[i], Integer.MAX_VALUE);
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int wt = edge[2];
            adjList[from].add(new int[]{to, wt});
            adjList[to].add(new int[]{from, wt});
        }

        for (int i = 0; i < n; i++) {
            dijkstra(adjList, n, shortestPath[i], i);
        }

        return cityHelper(n, shortestPath, distanceThreshold);
    }
}
