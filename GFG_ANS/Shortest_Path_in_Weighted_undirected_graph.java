// Time Complexity:O(ElogV)
// Space Complexity: OO(E+V)

class Solution {
    static class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }
        
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[1] = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        pq.add(new Pair(1, 0));
        
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int uDist = current.weight;
            
            if (uDist > dist[u]) {
                continue;
            }
            
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        
        int node = n;
        while (node != -1) {
            path.add(node);
            node = parent[node];
        }
        Collections.reverse(path);
        
        List<Integer> result = new ArrayList<>();
        result.add(dist[n]);
        result.addAll(path);
        return result;
    }
}
