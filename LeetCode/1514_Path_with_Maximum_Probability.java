// Dijkastra's algorithm using a PQ

// works fine considering no -ve weights 

class Solution {
    static class Pair {
        int node;
        double prob;
        
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adjList.get(u).add(new Pair(v, prob));
            adjList.get(v).add(new Pair(u, prob));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currNode = current.node;
            double currProb = current.prob;

            if (currNode == end_node) {
                return currProb;
            }

            for (Pair neighbor : adjList.get(currNode)) {
                int nextNode = neighbor.node;
                double edgeProb = neighbor.prob;

                if (currProb * edgeProb > maxProb[nextNode]) {
                    maxProb[nextNode] = currProb * edgeProb;
                    pq.add(new Pair(nextNode, maxProb[nextNode]));
                }
            }
        }

        return 0.0;
    }
}
