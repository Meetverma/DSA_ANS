//Time Complexity: O( N + M ) 
//Space Complexity: O( N + M );

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) { 
            adjList.add(new ArrayList<>());
        }


        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //Starting from 1


        HashMap<Integer, ArrayList<Integer>> visit_times = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            visit_times.put(i, new ArrayList<>());
        }

        int cur_time = 0;
        int isItSecond = -1;

        // Breadth-First Search (BFS)
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int element = queue.poll();

                // If we reach the target node n
                if (element == n) {
                    // Check if it's the second time we reach the target node
                    if (isItSecond != -1) {
                        return cur_time;
                    }
                    isItSecond = cur_time;
                }

                // Visit all neighbors
                for (int neighbor : adjList.get(element)) {
                    ArrayList<Integer> cur_nei = visit_times.get(neighbor);

                    // If this neighbor hasn't been visited yet or has been visited only once
                    if (cur_nei.size() == 0 || (cur_nei.size() == 1 && cur_nei.get(0) != cur_time)) {
                        queue.add(neighbor);
                        visit_times.get(neighbor).add(cur_time);
                    }
                }
            }

            //signal change
            if ((cur_time / change) % 2 == 1) {
                cur_time += change - (cur_time % change);
            }

            //Incrementing time
            cur_time += time;
        }

        // If we can't find the second minimum time, return -1
        return -1;
    }
}
